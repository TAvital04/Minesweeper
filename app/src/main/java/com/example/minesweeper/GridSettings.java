package com.example.minesweeper;

import android.graphics.Color;
import android.os.Bundle;

public class GridSettings {
    // Variables
    private int rows;
    private int columns;
    private int mines;

    // Constructors
    public GridSettings() {
        this.rows = 7;
        this.columns = 7;
        this.mines = 15;
    }
    public GridSettings(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
    }

    // Methods


    // Getters/Setters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    public Bundle getBundle() {
        Bundle result = new Bundle();

        result.putInt("rows", rows);
        result.putInt("columns", columns);
        result.putInt("mines", mines);

        return result;
    }

    public static GridSettings getFromBundle(Bundle bundle) {
        int rows = bundle.getInt("rows");
        int columns = bundle.getInt("columns");
        int mines = bundle.getInt("mines");

        return new GridSettings(rows, columns, mines);
    }
}
