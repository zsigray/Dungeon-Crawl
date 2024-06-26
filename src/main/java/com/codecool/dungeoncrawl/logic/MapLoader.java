package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.monsters.Goblin;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.data.actors.monsters.Spider;
import com.codecool.dungeoncrawl.data.items.Flower;
import com.codecool.dungeoncrawl.data.items.FlowerType;
import com.codecool.dungeoncrawl.data.items.Key;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map2.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case 'b':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'r':
                            cell.setType(CellType.RIVER);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.addSkeleton(new Skeleton(cell));
                            break;
                        case '*':
                            cell.setType(CellType.FLOOR);
                            map.addSpider(new Spider(cell));
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.addGoblin(new Goblin(cell));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case '1':
                            cell.setType(CellType.FLOOR);
                            new Flower(FlowerType.RED, cell);
                            break;
                        case '2':
                            cell.setType(CellType.FLOOR);
                            new Flower(FlowerType.BLUE, cell);
                            break;
                        case '3':
                            cell.setType(CellType.FLOOR);
                            new Flower(FlowerType.YELLOW, cell);
                            break;
                        case '4':
                            cell.setType(CellType.FLOOR);
                            new Flower(FlowerType.WHITE, cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case '-':
                            cell.setType(CellType.DOORCLOSED);
                            break;
                        case '+':
                            cell.setType(CellType.DOOROPEN);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
