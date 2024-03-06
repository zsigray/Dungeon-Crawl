package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public class Flower implements Drawable {

    private FlowerType type;
    private Cell cell;


    public Flower(FlowerType type, Cell cell) {
        this.type = type;
        this.cell = cell;
        this.cell.setItem(this);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public FlowerType getType() {
        return type;
    }

    public Cell getCell() {
        return cell;
    }
}
