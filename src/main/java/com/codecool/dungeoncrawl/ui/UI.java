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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;
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
        if (keyEvent.getCode() == KeyCode.K) {
            TilePane r = new TilePane();
            System.out.println("hi");
            // create a label to show the input in text dialog
            Label l = new Label("no text input");

            // create a text input dialog
            TextInputDialog td = new TextInputDialog();

            // create a button
            Button d = new Button("click");

            // create a event handler
            td.showAndWait();

            // set the text of the label
            l.setText(td.getEditor().getText());

            // add button and label
            r.getChildren().add(d);
            r.getChildren().add(l);
            if (Objects.equals(td.getEditor().getText(), "Sara"
                    ) || Objects.equals(td.getEditor().getText(), "Zsofi"
            )  || Objects.equals(td.getEditor().getText(), "Balazs"
            )) {
                logic.getMap().getPlayer().setFly();
            }

            Scene sc = new Scene(r, 500, 300);
            mainStage.setScene(sc);
        }

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
                    Tiles.drawTile(context, cell.getActor(), x, y, 1.5);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y, 1.5);
                } else {
                    Tiles.drawTile(context, cell, x, y, 1.5);
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
