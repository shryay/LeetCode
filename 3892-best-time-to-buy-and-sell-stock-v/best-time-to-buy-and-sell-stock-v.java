class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] t = new long[n + 1][k + 1][3];
        for (int tx = 0; tx <= k; tx++) {
            t[n][tx][0] = 0;
            t[n][tx][1] = Long.MIN_VALUE / 2;
            t[n][tx][2] = Long.MIN_VALUE / 2;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int tx = 0; tx <= k; tx++) {
                t[i][tx][0] = t[i + 1][tx][0];
                if (tx > 0) {
                    t[i][tx][0] = Math.max(
                        t[i][tx][0],
                        Math.max(
                            -prices[i] + t[i + 1][tx][1],
                             prices[i] + t[i + 1][tx][2]
                        )
                    );
                }
                t[i][tx][1] = t[i + 1][tx][1];
                if (tx > 0) {
                    t[i][tx][1] = Math.max(
                        t[i][tx][1],
                        prices[i] + t[i + 1][tx - 1][0]
                    );
                }
                t[i][tx][2] = t[i + 1][tx][2];
                if (tx > 0) {
                    t[i][tx][2] = Math.max(
                        t[i][tx][2],
                        -prices[i] + t[i + 1][tx - 1][0]
                    );
                }
            }
        }
        return t[0][k][0];
    }
}