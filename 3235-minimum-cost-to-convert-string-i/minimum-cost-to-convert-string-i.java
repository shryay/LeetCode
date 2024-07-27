class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int numLetters = 26;
        long[][] minCost = new long[numLetters][numLetters];
        for (int i = 0; i < numLetters; i++) {
            Arrays.fill(minCost[i], Long.MAX_VALUE);
            minCost[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }
        for (int k = 0; k < numLetters; k++) {
            for (int i = 0; i < numLetters; i++) {
                for (int j = 0; j < numLetters; j++) {
                    if (minCost[i][k] != Long.MAX_VALUE && minCost[k][j] != Long.MAX_VALUE) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int srcChar = source.charAt(i) - 'a';
                int tgtChar = target.charAt(i) - 'a';
                long costToConvert = minCost[srcChar][tgtChar];
                if (costToConvert == Long.MAX_VALUE) {
                    return -1;
                }
                totalCost += costToConvert;
            }
        }
        return totalCost;
    }
}