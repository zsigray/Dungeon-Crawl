package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Down implements KeyHandler {
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map, GraphicsContext context) {
        if (code.equals(event.getCode())) {
            if(map.getPlayer().move(0, 1))
            context.translate(0, -32);
        }
    }

}
