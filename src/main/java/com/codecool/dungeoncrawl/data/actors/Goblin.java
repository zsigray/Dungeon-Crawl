package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Goblin extends Actor{
    public Goblin(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "goblin";
    }
}
