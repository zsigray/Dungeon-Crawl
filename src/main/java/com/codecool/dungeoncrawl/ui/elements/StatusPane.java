package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label flowerTextLabel;
    private Label flowerValueLabel;
    private Label keyTextLabel;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("❤️: ");
        healthValueLabel = new Label();
        flowerTextLabel = new Label("🌷: ");
        flowerValueLabel = new Label();
        keyTextLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(flowerTextLabel, 0, 1);
        ui.add(flowerValueLabel, 1, 1);
        ui.add(keyTextLabel, 0, 2);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }
    public void setFlowerValue(String text) {
        this.flowerValueLabel.setText(text);
    }

    public void keyTextLabel() {
        this.keyTextLabel.setText("🗝");
    }
}
