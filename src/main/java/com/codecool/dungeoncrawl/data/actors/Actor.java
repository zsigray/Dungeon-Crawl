package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Objects;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (moveIsPossible(nextCell)) {
            System.out.println(nextCell.getActor());
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    protected boolean moveIsPossible(Cell nextCell) {
        return nextCell.getTileName().equals(CellType.FLOOR.getTileName())
                && nextCell.getActor() == null
                || nextCell.getTileName().equals("openedDoor");
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
