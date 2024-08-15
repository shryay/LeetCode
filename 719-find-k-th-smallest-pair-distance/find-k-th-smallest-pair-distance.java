class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (countPairsWithMaxDistance(mid, nums) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int countPairsWithMaxDistance(int dist, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right) >> 1;
                int target = nums[i] - dist;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            count += i - left;
        }
        return count;
    }
}