class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // // Approach-1 (Simple using HashMap)
        // // T.C : O(n^2)
        // // S.C : O(n^2)
        // int n = grid.length;
        // int N = n * n; // total elements
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int a = -1;
        // int b = -1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
        //     }
        // }
        // //[1...N]
        // for (int num = 1; num <= N; num++) {
        //     if (!map.containsKey(num)) {
        //         b = num;
        //     } else if (map.get(num) == 2) {
        //         a = num;
        //     }

        //     if (a != -1 && b != -1) {
        //         break;
        //     }
        // }
        // return new int[]{a, b};


        // Approach-2 (using maths)
        // T.C : O(n^2)
        // S.C : O(1)
        int n = grid.length;

        long N = (long) n * n;

        long gridSum = 0;
        long gridSqSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridSum += grid[i][j];
                gridSqSum += (long) grid[i][j] * grid[i][j];
            }
        }

        long sum = (N * (N + 1)) / 2; // Expected sum of N natural numbers
        long sqSum = (N * (N + 1) * (2 * N + 1)) / 6; // Expected sq sum of natural numbers

        long sqDiff = gridSqSum - sqSum;
        long sumDiff = gridSum - sum;

        int a = (int) ((sqDiff / sumDiff + sumDiff) / 2);
        int b = (int) ((sqDiff / sumDiff - sumDiff) / 2);

        return new int[]{a, b};
    }
}