class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid, int r, int c) {
        boolean[] unique = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || unique[val]) {
                    return false;
                }
                unique[val] = true;
            }
        }
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        return (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] == sum &&
                grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] == sum &&
                grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] == sum &&
                grid[r][c] + grid[r + 1][c] + grid[r + 2][c] == sum &&
                grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] == sum &&
                grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] == sum &&
                grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] == sum &&
                grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] == sum);
    }
}