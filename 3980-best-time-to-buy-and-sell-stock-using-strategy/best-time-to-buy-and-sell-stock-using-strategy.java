class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long actualProfit = 0;
        long[] profit = new long[n];
        for (int idx = 0; idx < n; idx++) {
            profit[idx] = (long) strategy[idx] * prices[idx];
            actualProfit += profit[idx];
        }
        long originalWindowProfit = 0;
        long modifiedWindowProfit = 0;
        long maxGain = 0;
        int i = 0, j = 0;
        while (j < n) {
            originalWindowProfit += profit[j];
            if (j - i + 1 > k / 2) {
                modifiedWindowProfit += prices[j];
            }
            if (j - i + 1 > k) {
                originalWindowProfit -= profit[i];
                modifiedWindowProfit -= prices[i + k / 2];
                i++;
            }
            if (j - i + 1 == k) {
                maxGain = Math.max(maxGain, modifiedWindowProfit - originalWindowProfit);
            }
            j++;
        }
        return actualProfit + maxGain;
    }
}