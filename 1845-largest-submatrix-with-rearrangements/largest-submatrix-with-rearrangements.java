class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        for (int row = 1; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] == 1) {
                    matrix[row][col] = matrix[row - 1][col] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int[] currentRow : matrix) {
            Arrays.sort(currentRow);
            int width = 1;
            for (int col = numCols - 1; col >= 0 && currentRow[col] > 0; col--) {
                int currentArea = currentRow[col] * width;
                maxArea = Math.max(maxArea, currentArea);
                width++;
            }
        }
        return maxArea;
    }
}