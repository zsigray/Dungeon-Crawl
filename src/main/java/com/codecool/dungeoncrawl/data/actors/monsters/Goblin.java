package com.codecool.dungeoncrawl.data.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.List;

public class Goblin extends Actor implements Monster {

    private boolean flower = false;
    private String tileName = "goblin";

    public Goblin(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void followPlayer(Cell targetCell) {
        Cell nextCell = getClosestCell(cell.getAllNeighboringCells(), targetCell);
        this.moveToNextCell(nextCell);
    }

    private int getDistance(Cell cellA, Cell cellB) {
        int orthogonalDistance = 10;
        int diagonalDistance = 14;
        int dstX = Math.abs(cellA.getX() - cellB.getX());
        int dstY = Math.abs(cellA.getY() - cellB.getY());
        if (dstX > dstY)
            return diagonalDistance * dstY + orthogonalDistance * (dstX - dstY);
        return diagonalDistance * dstX + orthogonalDistance * (dstY - dstX);
    }

    private Cell getClosestCell(List<Cell> neighboringCells, Cell targetCell) {

        Cell closestCell = neighboringCells.get(0);
        for (Cell neighborCell : neighboringCells) {
            if (getDistance(neighborCell, targetCell) < getDistance(closestCell, targetCell)) {
                closestCell = neighborCell;
            }
        }
        return closestCell;
    }

    private void moveToNextCell(Cell nextCell) {
        int xMoveUnit = nextCell.getX() - this.cell.getX();
        int yMoveUnit = nextCell.getY() - this.cell.getY();

        this.move(xMoveUnit, yMoveUnit);
    }

    @Override
    public boolean hasFlower() {
        return flower;
    }

    @Override
    public void giveFlowerAndTransform() {
        this.flower = true;
        this.tileName = "fairy3";
    }

}
