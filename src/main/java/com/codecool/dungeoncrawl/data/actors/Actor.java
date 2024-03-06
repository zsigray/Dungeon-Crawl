package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public boolean move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean moveIsPossible = moveIsPossible(nextCell);
        if (moveIsPossible) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
        return moveIsPossible;
    }

    public boolean moveIsPossible(Cell nextCell) {
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
