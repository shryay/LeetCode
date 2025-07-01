class Solution {
    public void setZeroes(int[][] matrix) {
        // Approch-1 (Using extra space of m*n)
        // T.C : O(m*n*(m+n))
        // S.C : O(m*n)
        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of cols
        int[][] temp = new int[m][n]; // temporary matrix
        // copying matrix to temp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        // implementation in temp matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        temp[i][k] = 0; // zero out the entire row
                    }
                    for (int k = 0; k < m; k++) {
                        temp[k][j] = 0; // zero out the entire column
                    }
                }
            }
        }
        // re-copy the temp matrix to original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}