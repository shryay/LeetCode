class Solution {
    private static final int[] DIRS = new int[] { -1, 0, 1, 0, -1 };
    private int[][] grid;
    private int numRows;
    private int numCols;
    public int minDays(int[][] grid) {
        this.grid = grid;
        numRows = grid.length;
        numCols = grid[0].length;
        if (countIslands() != 1) {
            return 0;
        }
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands() != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    private int countIslands() {
        int count = 0;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    ++count;
                }
            }
        }
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return count;
    }
    private void dfs(int row, int col) {
        grid[row][col] = 2;
        for (int k = 0; k < 4; ++k) {
            int newRow = row + DIRS[k], newCol = col + DIRS[k + 1];
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol);
            }
        }
    }
}