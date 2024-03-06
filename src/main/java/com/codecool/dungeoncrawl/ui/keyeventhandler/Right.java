package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Right implements KeyHandler {
    public static final KeyCode code = KeyCode.RIGHT;

    @Override
    public void perform(KeyEvent event, GameMap map, GraphicsContext context) {
        if(code.equals(event.getCode())) {
            if(map.getPlayer().move(1, 0))
            context.translate(-32, +0);
        }
    }
}
