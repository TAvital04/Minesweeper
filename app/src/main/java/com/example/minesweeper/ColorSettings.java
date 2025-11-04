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
        coveredCell = R.color.primaryColor;
        uncoveredCell = R.color.secondaryColor;
        suspectedCell = R.color.orange;
        mine = R.color.red;
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
