package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

public class GameLogic {
    private GameMap map;

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
    public void removeFlowerFromPlayer() {
        map.getPlayer().removeFlower();
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

    public boolean getKeyFromPlayer() {
        return map.getPlayer().hasKey();
    }
}
