package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.monsters.Monster;

public class GameLogic {
    private final GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public void addFlowerToPlayer() {
        map.getPlayer().addFlower();
    }

    public int getFlowersFromPlayer() {
        return map.getPlayer().getFlowers();
    }

    public GameMap getMap() {
        return map;
    }

    public void pickUpKey() {
        map.getPlayer().pickUpKey();
    }

    public void handleCombat(Cell playerCell) {
        for (Cell neighborCell : playerCell.getNonDiagonalNeighboringCells()) {
            if (neighborCell.getActor() != null) {
                Actor neighborActor = neighborCell.getActor();
                Monster monster = (Monster) neighborActor;
                Player player = map.getPlayer();
                int flowerNumber = player.getFlowers();
                if (flowerNumber <= 0 && !monster.hasFlower()) {
                    player.takeDamage(2);
                    if (isGameOver()) {
                        this.map.rewriteCells("/game-over-map.txt");
                    }
                } else if (flowerNumber > 0 && !monster.hasFlower()) {
                    monster.giveFlowerAndTransform();
                    player.removeFlower();
                    if (map.areAllMonstersGood()) {
                        this.map.rewriteCells("/you-win-map.txt");
                    }
                }
            }
        }
    }
    public boolean isGameOver() {
        return map.getPlayer().getHealth() <= 0;
    }

}
