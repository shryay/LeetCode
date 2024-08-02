class Solution {
    public int minSwaps(int[] nums) {
        int onesCount = 0;
        for (int value : nums) {
            onesCount += value;
        }
        int n = nums.length;
        int[] sumArray = new int[(n << 1) + 1];
        for (int i = 0; i < (n << 1); ++i) {
            sumArray[i + 1] = sumArray[i] + nums[i % n];
        }
        int maxOnes = 0;
        for (int i = 0; i < (n << 1); ++i) {
            int j = i + onesCount - 1;
            if (j < (n << 1)) {
                maxOnes = Math.max(maxOnes, sumArray[j + 1] - sumArray[i]);
            }
        }
        return onesCount - maxOnes;
    }
}