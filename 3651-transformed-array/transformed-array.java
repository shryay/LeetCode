class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int arrayLength = nums.length;
        int[] result = new int[arrayLength];
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            if (nums[currentIndex] == 0) {
                result[currentIndex] = 0;
            } else {
                int targetIndex = ((currentIndex + nums[currentIndex] % arrayLength + arrayLength) % arrayLength);
                result[currentIndex] = nums[targetIndex];
            }
        }
        return result;
    }
}