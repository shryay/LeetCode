class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPairSum = 0;
        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength / 2; i++) {
            int currentPairSum = nums[i] + nums[arrayLength - i - 1];
            maxPairSum = Math.max(maxPairSum, currentPairSum);
        }
        return maxPairSum;
    }
}