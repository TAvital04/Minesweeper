package com.example.minesweeper;

public class Minesweeper {
    // Variables
    private Grid grid;
    private ColorSettings colorSettings;
    private boolean started;

    // Constructors
    public Minesweeper() {
        grid = new Grid();
        colorSettings = new ColorSettings();
        started = false;
    }

    // Methods
    public void printMinesweeper() {

    }

    // Getters/Setters
    public Grid getGrid() {
        return grid;
    }

    public ColorSettings getColorSettings() {
        return colorSettings;
    }

    public boolean getStarted() {
        return started;
    }
}
