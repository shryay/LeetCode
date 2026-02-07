class Solution {
    public int minimumDeletions(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        int bCount = 0;
        for (int i = 1; i <= length; i++) {
            char currentChar = s.charAt(i - 1);
            if (currentChar == 'b') {
                dp[i] = dp[i - 1];
                bCount++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, bCount);
            }
        }
        return dp[length];
    }
}