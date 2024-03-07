package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Item implements Drawable {

    protected Cell cell;
    protected String tileName;

    public Item(Cell cell, String tileName) {
        this.cell = cell;
        this.tileName = tileName;
        this.cell.setItem(this);
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public Cell getCell() {
        return cell;
    }
}
