package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.ui.Tiles;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map, GraphicsContext context) {
        if (code.equals(event.getCode()) &&
                (map.getPlayer().move(0, 1))) {
            context.translate(0, -1 * Tiles.TILE_WIDTH);
        }
    }

}
