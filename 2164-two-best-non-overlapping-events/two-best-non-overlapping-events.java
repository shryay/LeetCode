class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], events[i][2]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];
            int idx = binarySearch(events, start);
            if (idx != -1) {
                ans = Math.max(ans, value + prefixMax[idx]);
            }
            ans = Math.max(ans, value);
        }
        return ans;
    }
    private int binarySearch(int[][] events, int start) {
        int lo = 0, hi = events.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][1] < start) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}