class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixN = new int[n + 1];
        int[] suffixY = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixN[i + 1] = prefixN[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;
        for (int k = 0; k <= n; k++) {
            int penalty = prefixN[k] + suffixY[k];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = k;
            }
        }
        return bestHour;
    }
}