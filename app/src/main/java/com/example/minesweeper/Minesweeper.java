package com.example.minesweeper;

import android.os.Bundle;

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

    public Minesweeper(Grid grid, ColorSettings colorSettings, boolean started) {
        this.grid = grid;
        this.colorSettings = colorSettings;
        this.started = started;
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

    public Bundle getBundle() {
        Bundle result = new Bundle();

        result.putBundle("grid", grid.getBundle());
        result.putBundle("colorSettings", colorSettings.getBundle());
        result.putBoolean("started", started);

        return result;
    }

    public static Minesweeper getFromBundle(Bundle bundle) {
        Grid grid = Grid.getFromBundle(bundle.getBundle("grid"));
        ColorSettings colorSetting = ColorSettings.getFromBundle(bundle.getBundle("colorSettings"));
        boolean started = bundle.getBoolean("started");

        return new Minesweeper(grid, colorSetting, started);
    }
}
