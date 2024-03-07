package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.monsters.Goblin;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.data.actors.monsters.Spider;
import com.codecool.dungeoncrawl.data.items.Flower;
import com.codecool.dungeoncrawl.data.items.FlowerType;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.logic.MapLoader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private Player player;

    private final List<Spider> spiders = new ArrayList<>();
    private final List<Goblin> goblins = new ArrayList<>();
    private final List<Skeleton> skeletons = new ArrayList<>();

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

    public void addSpider(Spider spider) {
        spiders.add(spider);
    }

    public void addGoblin(Goblin goblin) {
        goblins.add(goblin);
    }

    public void addSkeleton(Skeleton skeleton) {
        skeletons.add(skeleton);
    }

    public boolean areAllMonstersGood() {
        boolean monstersGood = true;
        for (Spider spider : spiders) {
            if (!spider.hasFlower()) {
                monstersGood = false;
            }
        }
        for (Goblin goblin : goblins) {
            if (!goblin.hasFlower()) {
                monstersGood = false;
            }
        }

        for (Skeleton skeleton : skeletons) {
            if (!skeleton.hasFlower()) {
                monstersGood = false;
            }
        }

        return monstersGood;
    }

    public void moveMonsters() {
        for (Spider spider : spiders) {
            spider.randomMove();
        }

        for (Goblin goblin : goblins) {
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

    public void rewriteCells(String fileName) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        this.width = scanner.nextInt();
        this.height = scanner.nextInt();
        scanner.nextLine(); // empty line

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = this.getCell(x, y);
                    if (cell.equals(player.getCell())) continue;
                    cell.setActor(null);
                    cell.setItem(null);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '*':
                            cell.setType(CellType.FLOOR);
                            new Flower(FlowerType.RED, cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            this.setPlayer(new Player(cell));
                            break;

                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
    }
}
