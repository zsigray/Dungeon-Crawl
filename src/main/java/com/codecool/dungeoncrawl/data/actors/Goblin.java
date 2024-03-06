package com.codecool.dungeoncrawl.data.actors;
import com.codecool.dungeoncrawl.data.Cell;
import java.util.List;

public class Goblin extends Actor {

    public Goblin(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "goblin";
    }

    public void followPlayer(Cell targetCell) {
        Cell nextCell = getClosestCell(cell.getNeighboringCells(), targetCell);
        this.moveToNextCell(nextCell);
    }

    private int getDistance(Cell cellA, Cell cellB) {
        int dstX = Math.abs(cellA.getX() - cellB.getX());
        int dstY = Math.abs(cellA.getY() - cellB.getY());
        if (dstX > dstY)
            return 14 * dstY + 10 * (dstX - dstY);
        return 14 * dstX + 10 * (dstY - dstX);
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


}
