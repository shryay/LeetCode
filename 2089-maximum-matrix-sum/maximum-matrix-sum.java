class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negatives = 0;
        int minAbs = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negatives++;
                sum += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }
        if (negatives % 2 == 1) {
            sum -= 2L * minAbs;
        }
        return sum;
    }
}