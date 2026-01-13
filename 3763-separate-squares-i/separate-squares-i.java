class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for (int[] s : squares) {
            double y = s[1];
            double len = s[2];
            totalArea += len * len;
            low = Math.min(low, y);
            high = Math.max(high, y + len);
        }
        double target = totalArea / 2.0;
        while (high - low > 1e-5) {
            double mid = (low + high) / 2.0;
            double areaAbove = 0;
            for (int[] s : squares) {
                double y = s[1];
                double len = s[2];
                if (y >= mid) {
                    areaAbove += len * len;
                } else if (y + len > mid) {
                    areaAbove += (y + len - mid) * len;
                }
            }
            if (areaAbove > target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}