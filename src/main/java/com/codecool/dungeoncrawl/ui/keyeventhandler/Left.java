package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.ui.Tiles;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map, GraphicsContext context) {
        if(code.equals(event.getCode()) &&
                map.getPlayer().move(-1, 0)) {
            context.translate(Tiles.TILE_WIDTH, +0);
        }
    }
}
