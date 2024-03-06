package com.codecool.dungeoncrawl.data.items;

public enum FlowerType {
    BLUE("flower1"),
    YELLOW("flower2"),
    RED("flower3"),
    WHITE("flower4");

    private final String tileName;

    FlowerType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
