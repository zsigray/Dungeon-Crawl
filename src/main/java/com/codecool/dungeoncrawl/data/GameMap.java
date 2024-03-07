package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.monsters.Goblin;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.monsters.Spider;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Player player;

    private final List<Spider> spiders = new ArrayList<>();
    private final List<Goblin> goblins = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addSpider(Spider spider) { spiders.add(spider);}
    public void addGoblin(Goblin goblin) { goblins.add(goblin);}

    public void moveMonsters(){
        for (Spider spider : spiders){
            spider.randomMove();
        }

        for (Goblin goblin : goblins){
            goblin.followPlayer(player.getCell());
        }
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
