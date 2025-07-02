class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfPermutations(int n, int[][] requirements) {
        // Build map for fast requirement lookup
        int[] required = new int[n]; 
        Arrays.fill(required, -1);
        for (int[] req : requirements) {
            required[req[0]] = req[1];
        }
        
        // Maximum inversion count = n*(n-1)/2
        int maxInversions = n * (n - 1) / 2;
        int[][] dp = new int[n + 1][maxInversions + 1];
        dp[0][0] = 1; // base case: one permutation of length 0 with 0 inversions

        for (int i = 1; i <= n; i++) {
            // prefix sum for dp[i-1][*]
            int[] prefix = new int[maxInversions + 2];
            for (int j = 0; j <= maxInversions; j++) {
                prefix[j + 1] = (prefix[j] + dp[i - 1][j]) % MOD;
            }

            for (int j = 0; j <= maxInversions; j++) {
                int low = Math.max(0, j - (i - 1));
                int high = j;
                dp[i][j] = (prefix[high + 1] - prefix[low] + MOD) % MOD;
            }

            // apply requirement at i-1 index
            if (required[i - 1] != -1) {
                for (int j = 0; j <= maxInversions; j++) {
                    if (j != required[i - 1]) dp[i][j] = 0;
                }
            }
        }

        // total permutations of size n with any inversion count satisfying the requirement
        int ans = 0;
        for (int val : dp[n]) ans = (ans + val) % MOD;
        return ans;
    }
}