package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Flower extends Item {

    private FlowerType type;

    public Flower(FlowerType type, Cell cell) {
        super(cell, type.getTileName());
        this.type = type;
    }

    public FlowerType getType() {
        return type;
    }
}
