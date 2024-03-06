package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Up implements KeyHandler {
    public static final KeyCode code = KeyCode.UP;

    @Override
    public void perform(KeyEvent event, GameMap map, GraphicsContext context) {
        if(code.equals(event.getCode())) {
            if(map.getPlayer().move(0, -1))
            context.translate(0, +32);
        }
    }
}
