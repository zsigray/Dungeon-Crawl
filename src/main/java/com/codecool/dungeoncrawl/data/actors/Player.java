package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Player extends Actor {

    private int flowers = 0;
    private boolean key = false;
    private boolean canFly = false;

    public Player(Cell cell) {
        super(cell);
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

    public boolean canFly(){
        return this.canFly;
    }

    public void setFly(){
        this.canFly = true;
    }

    @Override
    public boolean moveIsPossible(Cell nextCell) {
        return super.moveIsPossible(nextCell)
                || this.hasKey() && nextCell.getType() == CellType.DOORCLOSED ||
                this.canFly;
    }


}
