class Solution {
    private static final int MOD = 1_000_000_007;
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        long ans = 0;

        for (int i = 1; i <= n - 2; i++) {
            long leftSum = pre[i];

            // First j where midSum >= leftSum
            int l = i + 1, r = n - 1;
            int first = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (pre[mid] - pre[i] >= leftSum) {
                    first = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (first == -1) continue;

            // Last j where rightSum >= midSum
            l = first;
            r = n - 1;
            int last = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (pre[n] - pre[mid] >= pre[mid] - pre[i]) {
                    last = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (last != -1) {
                ans = (ans + (last - first + 1)) % MOD;
            }
        }

        return (int) ans;
    }
}