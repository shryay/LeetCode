class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // // Approach-1 (Brute Force)
        // // T.C : O(m^3 * n^3)
        // // S.C : O(1)
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int result = 0;
        // // Trying all possible start points (x, y)
        // for (int startRow = 0; startRow < m; startRow++) {
        //     for (int startCol = 0; startCol < n; startCol++) {
        //         // Trying all possible ending points (x', y')
        //         for (int endRow = startRow; endRow < m; endRow++) {
        //             for (int endCol = startCol; endCol < n; endCol++) {
        //                 // Now iterating the start points and end points
        //                 int sum = 0;
        //                 for (int i = startRow; i <= endRow; i++) {
        //                     for (int j = startCol; j <= endCol; j++) {
        //                         sum += matrix[i][j];
        //                     }
        //                 }
        //                 if (sum == target)
        //                 result++;
        //             }
        //         }
        //     }
        // }
        // return result;


        // Approach-2 (Using prefix sum)
        // T.C : O(n^2 * m)
        // S.C : O(m)
        int rows = matrix.length; // m
        int cols = matrix[0].length; // n
        // First take the cumulative sum row-wise
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }
        // Now, find the "No. of subarrays with sum k" in the downward direction
        int result = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int currCol = startCol; currCol < cols; currCol++) {
                // We need to find all submatrices sum

                // Now comes the concept of "No. of subarrays with sum k"
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                // Go downwards row-wise
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);
                    if (map.containsKey(sum - target))
                    result += map.get(sum - target);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }
}