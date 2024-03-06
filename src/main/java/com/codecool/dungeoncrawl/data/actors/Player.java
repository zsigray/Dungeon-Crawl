package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    @Override
    protected boolean moveIsPossible(Cell nextCell) {
        return super.moveIsPossible(nextCell)
                || this.hasKey() && nextCell.getType() == CellType.DOORCLOSED;
    }

    public boolean hasKey (){
        return false;
    }
}
