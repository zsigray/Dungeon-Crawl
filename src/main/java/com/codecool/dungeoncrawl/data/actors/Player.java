package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class Player extends Actor {

    private int flowers = 0;
    private boolean key = false;

    public Player(Cell cell) {
        super(cell);
    }

    public void setCell(GameMap map, int x, int y){
        this.cell = new Cell(map, 0, 0, CellType.FLOOR);
    }

    public String getTileName() {
        return "player";
    }

    public int getFlowers() {
        return flowers;
    }

    public void addFlower() {
        this.flowers++;
    }
    public void removeFlower() {
        this.flowers--;
    }

    public void pickUpKey() {
        this.key = true;
    }

    public boolean hasKey() {
        return key;
    }

    @Override
    public boolean moveIsPossible(Cell nextCell) {
        return super.moveIsPossible(nextCell)
                || this.hasKey() && nextCell.getType() == CellType.DOORCLOSED;
    }


}
