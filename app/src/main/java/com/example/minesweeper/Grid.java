package com.example.minesweeper;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
    // Variables
    private CellStates[][] gameState;
    private GridSettings gridSettings;

    // Constructors
    public Grid() {
        gridSettings = new GridSettings();
        gameState = generateNewGameState(gridSettings);
    }
    public Grid(CellStates[][] gameState, GridSettings gridSettings) {
        this.gameState = gameState;
        this.gridSettings = gridSettings;
    }

    // Enums
    public enum CellStates {
        COVERED,
        UNCOVERED,
        SUSPECTED,
        MINE
    }

    // Methods
    public CellStates[][] generateNewGameState(GridSettings gridSettings) {
        CellStates[][] result = new CellStates[gridSettings.getRows()][gridSettings.getColumns()];

        for(CellStates[] row: result) {
            for(CellStates cell: row) {
                cell = CellStates.COVERED;
            }
        }

        double percentMines = gridSettings.getMines()/100.0;
        int mines = (int)(percentMines * gridSettings.getRows() * gridSettings.getColumns());

        Random random = new Random();
        boolean done;
        for(int i = 0; i < mines; i++) {
            done = false;
            while(!done) {
                int row = (int)(random.nextInt(gridSettings.getRows()));
                int column = (int)(random.nextInt(gridSettings.getColumns()));

                if(result[row][column] != CellStates.MINE) {
                    result[row][column] = CellStates.MINE;
                    done = true;
                }
            }
        }

        return result;
    }


    // Getters/Setters
    public CellStates[][] getGameState() {
        return gameState;
    }

    public Bundle getBundle() {
        Bundle result = new Bundle();

        result.putInt("rows", gameState.length);
        result.putInt("columns", gameState[0].length);

        ArrayList<Integer> gridArrayList = new ArrayList<>();
        for(CellStates[] row: gameState) {
            for(CellStates cell: row) {
                int cellAsInt;
                switch(cell) {
                    case COVERED:
                        cellAsInt = 0;
                        break;
                    case UNCOVERED:
                        cellAsInt = 1;
                        break;
                    case SUSPECTED:
                        cellAsInt = 2;
                        break;
                    case MINE:
                        cellAsInt = 3;
                        break;
                    default:
                        cellAsInt = -1;
                        break;
                }
                gridArrayList.add(cellAsInt);
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

        CellStates[][] grid = new CellStates[rows][columns];

        int gridArrayListIndex = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                CellStates cellAsCellStates;
                switch(gridArrayList.get(gridArrayListIndex)) {
                    case 0:
                        cellAsCellStates = CellStates.COVERED;
                        break;
                    case 1:
                        cellAsCellStates = CellStates.UNCOVERED;
                        break;
                    case 2:
                        cellAsCellStates = CellStates.SUSPECTED;
                        break;
                    case 3:
                        cellAsCellStates = CellStates.MINE;
                        break;
                    default:
                        throw new IllegalArgumentException("There was a problem unpacking the grid bundle");
                }
                grid[i][j] = cellAsCellStates;
                gridArrayListIndex++;
            }
        }

        GridSettings gridSettings = GridSettings.getFromBundle(bundle.getBundle("gridSettings"));

        return new Grid(grid, gridSettings);
    }
}
