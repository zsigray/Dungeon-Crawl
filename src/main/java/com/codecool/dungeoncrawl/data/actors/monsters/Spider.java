package com.codecool.dungeoncrawl.data.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.List;
import java.util.Random;

public class Spider extends Actor implements Monster {

    private boolean flower = false;
    private String tileName = "spider";

    public Spider(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void randomMove(){
        List<Integer> possibleMovements = List.of(-1, 0, 1);
        int dx = possibleMovements.get(new Random().nextInt(possibleMovements.size()));
        int dy = possibleMovements.get(new Random().nextInt(possibleMovements.size()));
        this.move(dx, dy);
    }

    @Override
    public boolean hasFlower() {
        return flower;
    }

    @Override
    public void giveFlowerAndTransform() {
        this.flower = true;
        this.tileName = "fairy2";
    }

}
