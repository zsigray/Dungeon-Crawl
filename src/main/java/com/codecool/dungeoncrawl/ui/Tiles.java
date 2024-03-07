package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(3, 2));
        tileMap.put("wall", new Tile(13, 16));
        tileMap.put("floor", new Tile(6, 0));
        tileMap.put("tree", new Tile(3, 2));
        tileMap.put("player", new Tile(25, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("spider", new Tile(28, 5));
        tileMap.put("goblin", new Tile(29, 2));
        tileMap.put("flower1", new Tile(27, 25));
        tileMap.put("flower2", new Tile(28, 25));
        tileMap.put("flower3", new Tile(29, 25));
        tileMap.put("flower4", new Tile(31, 25));
        tileMap.put("openedDoor", new Tile(4, 4));
        tileMap.put("closedDoor", new Tile(3, 4));
        tileMap.put("key", new Tile(18, 23));
        tileMap.put("fairy1", new Tile(23, 7));
        tileMap.put("fairy2", new Tile(21, 8));
        tileMap.put("fairy3", new Tile(21, 7));
        tileMap.put("bridge", new Tile(7, 5));
        tileMap.put("river", new Tile(8, 5));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
