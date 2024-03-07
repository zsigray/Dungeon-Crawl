package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOROPEN ("openedDoor"),
    DOORCLOSED("closedDoor"),
    TREE("tree"),
    RIVER("river"),
    BRIDGE("bridge");


    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
