class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        int s2 = 0;
        for (int i = 0; i < nums.length; i++) {
            s2 += nums[i];
        }
        int nmber = sum - s2;
        return nmber;
    }
}