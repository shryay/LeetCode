class Solution {
    private static class Result {
        long count;
        long wave;

        Result(long count, long wave) {
            this.count = count;
            this.wave = wave;
        }
    }

    // Memoization table: [idx][pre_prev][prev][is_limit][is_num]
    // 16 positions (for up to 10^15), 11 values for digits (-1 becomes 10), 2 choices for flags
    private Result[][][][][] memo;
    private String nStr;

    public long totalWaviness(long num1, long num2) {
        return solveUpto(num2) - solveUpto(num1 - 1);
    }

    private long solveUpto(long num) {
        if (num <= 0) return 0;
        
        nStr = String.valueOf(num);
        int len = nStr.length();
        
        // Reset or initialize the memoization matrix
        memo = new Result[len][11][11][2][2];
        
        return dfs(0, -1, -1, true, false).wave;
    }

    private Result dfs(int idx, int prePrev, int prev, boolean isLimit, boolean isNum) {
        // Base Case: If the whole number is processed
        if (idx == nStr.length()) {
            return isNum ? new Result(1, 0) : new Result(0, 0);
        }

        // Map -1 to index 10 for the array storage
        int ppIdx = (prePrev == -1) ? 10 : prePrev;
        int pIdx = (prev == -1) ? 10 : prev;
        int limIdx = isLimit ? 1 : 0;
        int numIdx = isNum ? 1 : 0;

        // Return memoized state if already processed
        if (memo[idx][ppIdx][pIdx][limIdx][numIdx] != null) {
            return memo[idx][ppIdx][pIdx][limIdx][numIdx];
        }

        int limit = isLimit ? (nStr.charAt(idx) - '0') : 9;
        long resCount = 0;
        long resWave = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextLimit = isLimit && (d == limit);

            if (!isNum) {
                // If a valid number hasn't started yet
                Result nextRes = dfs(idx + 1, -1, (d == 0 ? -1 : d), nextLimit, d > 0);
                resCount += nextRes.count;
                resWave += nextRes.wave;
            } else {
                // If a valid number is ongoing, check for peaks and valleys
                int isWv = 0;
                if (prePrev >= 0) {
                    if (prePrev < prev && prev > d) {
                        isWv = 1; // Peak detected
                    } else if (prePrev > prev && prev < d) {
                        isWv = 1; // Valley detected
                    }
                }

                Result nextRes = dfs(idx + 1, prev, d, nextLimit, true);
                resCount += nextRes.count;
                
                // Add waviness contributed by the current state across all downstream combinations
                resWave += nextRes.wave + (isWv * nextRes.count);
            }
        }

        Result result = new Result(resCount, resWave);
        memo[idx][ppIdx][pIdx][limIdx][numIdx] = result;
        return result;
    }
}