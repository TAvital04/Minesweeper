package com.example.minesweeper;

import android.os.Bundle;

import java.util.ArrayList;

public class Grid {
    // Variables
    private int[][] gameState;
    private GridSettings gridSettings;

    // Constructors
    public Grid(int[][] gameState, GridSettings gridSettings) {
        this.gameState = gameState;
        this.gridSettings = gridSettings;
    }

    // Methods


    // Getters/Setters
    public int[][] getGameState() {
        return gameState;
    }

    public Bundle getBundle() {
        Bundle result = new Bundle();

        result.putInt("rows", gameState.length);
        result.putInt("columns", gameState[0].length);

        ArrayList<Integer> gridArrayList = new ArrayList<>();
        for(int[] row: gameState) {
            for(int cell: row) {
                gridArrayList.add(cell);
            }
        }

        result.putIntegerArrayList("grid", gridArrayList);

        result.putBundle("gridSettings", gridSettings.getBundle());

        return result;
    }

    public static Grid getFromBundle(Bundle bundle) {
        int rows = bundle.getInt("rows");
        int columns = bundle.getInt("columns");
        ArrayList<Integer> gridArrayList = bundle.getIntegerArrayList("grid");

        int[][] grid = new int[rows][columns];

        int gridArrayListIndex = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                grid[i][j] = gridArrayList.get(gridArrayListIndex);
                gridArrayListIndex++;
            }
        }

        GridSettings gridSettings = GridSettings.getFromBundle(bundle.getBundle("gridSettings"));

        return new Grid(grid, gridSettings);
    }
}
