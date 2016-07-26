package com.guilherme.miguel;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Miguel Guilherme
 */
public class SunSpot {

    private int t; // Number of results requested
    private int n; // Grid size
    private int[][] grid;

    public SunSpot(int... input) {
        this.t = input[0];
        this.n = input[1];

        this.grid = new int[n][n];
        populateGrid(input);

    }

    /**
     * Populates the grid from the input data
     *
     * @param input the input data
     */
    private void populateGrid(int[] input) {
        int[] data = new int[input.length - 2];

        // Copy to new array
        for (int i = 0; i < data.length; i++) {
            data[i] = input[i + 2];
        }

        // Populate Grid
        int count = 0;
        for (int i = 0; i < n; i++) { // Rows
            for (int j = 0; j < n; j++) { // Columns
                grid[i][j] = data[count];
                count++;
            }
        }
    }

    /**
     * Analyse the data and retrieve the highest rated locations
     * and their respective scores
     *
     * @return The highest rated locations with scores
     */
    public String analyse() {

        // Populate the location scores map.
        // Since the test does not mention anything about repeated values I will use a Reversed TreeMap
        // to store the location stores in reversed order, this implementation does not store repeating elements
        Map<Integer, String> locationScores = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) { // Rows
            for (int j = 0; j < n; j++) { // Columns
                int score = generateScoreLocation(i, j);
                locationScores.put(score, String.format("(%d,%d score:%d)", i, j, score));
            }
        }

        String result = "";
        int tCount = 0;
        for (Entry<Integer, String> entry : locationScores.entrySet()) {
            result += entry.getValue() + " ";
            tCount++;
            if (tCount == t) break;
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * Generate the score location from a given location
     *
     * @param row    the row
     * @param column the column
     * @return the score location
     */
    private int generateScoreLocation(int row, int column) {
        boolean isFirstColumn = column == 0;
        boolean isLastColumn = column == n - 1;

        boolean isFirstRow = row == 0;
        boolean isLastRow = row == n - 1;

        // Same row
        int score = grid[row][column];
        if (!isFirstColumn) score += grid[row][column - 1];
        if (!isLastColumn) score += grid[row][column + 1];

        // Previous Row
        if (!isFirstRow) {
            if (!isFirstColumn) score += grid[row - 1][column - 1];
            score += grid[row - 1][column];
            if (!isLastColumn) score += grid[row - 1][column + 1];
        }

        // Next Row
        if (!isLastRow) {
            if (!isFirstColumn) score += grid[row + 1][column - 1];
            score += grid[row + 1][column];
            if (!isLastColumn) score += grid[row + 1][column + 1];
        }
        return score;
    }

}
