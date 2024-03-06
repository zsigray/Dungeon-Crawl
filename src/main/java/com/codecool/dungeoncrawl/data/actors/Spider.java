package com.codecool.dungeoncrawl.data.actors;
import com.codecool.dungeoncrawl.data.Cell;

import java.util.List;
import java.util.Random;

public class Spider extends Actor {

    public Spider(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "spider";
    }

    public void randomMove(){
        List<Integer> possibleMovements = List.of(-1, 0, 1);
        int dx = possibleMovements.get(new Random().nextInt(possibleMovements.size()));
        int dy = possibleMovements.get(new Random().nextInt(possibleMovements.size()));
        this.move(dx, dy);
    }

}
