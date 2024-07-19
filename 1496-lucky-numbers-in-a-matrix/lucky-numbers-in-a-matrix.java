class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMins = new int[m];
        for (int i = 0; i < m; ++i) {
            int minElement = matrix[i][0];
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                }
            }
            rowMins[i] = minElement;
        }
        for (int j = 0; j < n; ++j) {
            int maxInCol = Integer.MIN_VALUE;
            for (int i = 0; i < m; ++i) {
                if (matrix[i][j] > maxInCol) {
                    maxInCol = matrix[i][j];
                }
            }
            for (int i = 0; i < m; ++i) {
                if (rowMins[i] == maxInCol) {
                    luckyNumbers.add(rowMins[i]);
                }
            }
        }
        return luckyNumbers;
    }
}