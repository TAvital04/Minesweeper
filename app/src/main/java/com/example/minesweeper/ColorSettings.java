package com.example.minesweeper;

import android.graphics.Color;

public class ColorSettings {
    // Variables
    private int coveredCell;
    private int uncoveredCell;
    private int suspectedCell;
    private int mine;

    // Constructors
    public ColorSettings() {
        coveredCell = R.color.color_surface;
        uncoveredCell = R.color.color_surface_secondary;
        suspectedCell = R.color.color_accent_orange;
        mine = R.color.color_accent_red;
    }

    // Methods


    // Getters/Setters
    public int getCoveredCell() {
        return coveredCell;
    }

    public int getUncoveredCell() {
        return uncoveredCell;
    }

    public int getSuspectedCell() {
        return suspectedCell;
    }

    public int getMine() {
        return mine;
    }
}
