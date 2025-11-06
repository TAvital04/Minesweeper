package com.example.minesweeper;

import android.graphics.Color;
import android.os.Bundle;

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

    public ColorSettings(int coveredCell, int uncoveredCell, int suspectedCell, int mine) {
        this.coveredCell = coveredCell;
        this.uncoveredCell = uncoveredCell;
        this.suspectedCell = suspectedCell;
        this.mine = mine;
    }

    // Methods


    // Getters/Setters
    public int getCoveredCell() {
        return coveredCell;
    }
    public void setCoveredCell(int coveredCell) {
        this.coveredCell = coveredCell;
    }

    public int getUncoveredCell() {
        return uncoveredCell;
    }
    public void setUncoveredCell(int uncoveredCell) {
        this.uncoveredCell = uncoveredCell;
    }

    public int getSuspectedCell() {
        return suspectedCell;
    }
    public void setSuspectedCell(int suspectedCell) {
        this.suspectedCell = suspectedCell;
    }

    public int getMine() {
        return mine;
    }
    public void setMine(int mine) {
        this.mine = mine;
    }

    public Bundle getBundle() {
        Bundle result = new Bundle();

        result.putInt("coveredCell", coveredCell);
        result.putInt("uncoveredCell", uncoveredCell);
        result.putInt("suspectedCell", suspectedCell);
        result.putInt("mine", mine);

        return result;
    }

    public static ColorSettings getFromBundle(Bundle bundle) {
        int coveredCell = bundle.getInt("coveredCell");
        int uncoveredCell = bundle.getInt("uncoveredCell");
        int suspectedCell = bundle.getInt("suspectedCell");
        int mine = bundle.getInt("mine");

        return new ColorSettings(coveredCell, uncoveredCell, suspectedCell, mine);
    }
}
