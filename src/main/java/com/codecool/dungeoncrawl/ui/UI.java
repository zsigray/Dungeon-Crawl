package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Flower;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;
    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;

    private Random random;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap(), context);
        }

        refresh();
        logic.getMap().moveMonsters();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    if (cell.getActor() instanceof Player) {
                        handleItemPickUp(cell);
                        logic.handleCombat(cell);
                        if(cell.getType() == CellType.DOORCLOSED){
                            cell.setType(CellType.DOOROPEN);
                        }
                    }
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setFlowerValueText(logic.getFlowersFromPlayer());
    }

    private void handleItemPickUp(Cell cell) {
        if (cell.getItem() != null) {
            Drawable item = cell.getItem();
            if (item.getClass() == Flower.class) {
                logic.addFlowerToPlayer();
            } else if (item.getClass() == Key.class) {
                logic.pickUpKey();
                mainStage.setKeyValueText();
            }
            cell.setItem(null);
        }
    }
}
