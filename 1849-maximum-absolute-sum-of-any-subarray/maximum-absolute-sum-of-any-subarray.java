class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // Approach-1 (2 Pass - Kadane's Algorithm for maxsubarrysum and minsybarraysum)
        // T.C : O(2*n) ~= O(n)
        // S.C : O(1)
        int n = nums.length;
        int currSubSum = nums[0];
        int maxSubSum = nums[0];
        // Kadane's Algo for finding max subarray sum
        for (int i = 1; i < n; i++) {
            currSubSum = Math.max(nums[i], currSubSum + nums[i]);
            maxSubSum = Math.max(maxSubSum, currSubSum);
        }
        // Kadane's Algo for finding min subarray sum
        int minSubSum = nums[0];
        currSubSum = nums[0];
        for (int i = 1; i < n; i++) {
            currSubSum = Math.min(nums[i], currSubSum + nums[i]);
            minSubSum = Math.min(minSubSum, currSubSum);
        }
        return Math.max(maxSubSum, Math.abs(minSubSum));
    }
}