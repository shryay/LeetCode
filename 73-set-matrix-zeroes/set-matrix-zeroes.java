class Solution {
    public void setZeroes(int[][] matrix) {
        // // Approch-1 (Using extra space of m*n)
        // // T.C : O(m*n*(m+n))
        // // S.C : O(m*n)
        // int m = matrix.length; // no. of rows
        // int n = matrix[0].length; // no. of cols
        // int[][] temp = new int[m][n]; // temporary matrix
        // // copying matrix to temp
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         temp[i][j] = matrix[i][j];
        //     }
        // }
        // // implementation in temp matrix
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             for (int k = 0; k < n; k++) {
        //                 temp[i][k] = 0; // zero out the entire row
        //             }
        //             for (int k = 0; k < m; k++) {
        //                 temp[k][j] = 0; // zero out the entire column
        //             }
        //         }
        //     }
        // }
        // // re-copy the temp matrix to original matrix
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = temp[i][j];
        //     }
        // }


        // Approch-2 (Using m+n extra space)
        // T.C : O(m*n)
        // S.C : O(m+n)
        int m = matrix.length; // no. of rows
        int n = matrix[0].length; // no. of cols
        boolean[] row = new boolean[m]; // 1D array to represent rows
        boolean[] col = new boolean[n]; // 1D array to represent cols
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true; // mark it for zero
                    col[j] = true; // mark it for zero
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}