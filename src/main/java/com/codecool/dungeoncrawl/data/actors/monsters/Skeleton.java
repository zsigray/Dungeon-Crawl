package com.codecool.dungeoncrawl.data.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Skeleton extends Actor implements Monster {

    private boolean flower = false;
    private String tileName = "skeleton";

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    @Override
    public boolean hasFlower() {
        return flower;
    }

    @Override
    public void giveFlowerAndTransform() {
        this.flower = true;
        this.tileName = "fairy1";
    }
}
