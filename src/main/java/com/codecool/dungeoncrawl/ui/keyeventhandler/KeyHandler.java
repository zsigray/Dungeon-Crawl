package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public interface KeyHandler {
    void perform(KeyEvent event, GameMap map, GraphicsContext context);
}
