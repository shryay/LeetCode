class Solution {
    public void moveZeroes(int[] nums) {
        // // Time: O(N), Space: O(1)
        // int n = nums.length;
        // int lastNonZero = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] != 0) {
        //         nums[lastNonZero] = nums[i];
        //         lastNonZero++;
        //     }
        // }
        // for (int i = lastNonZero; i < n; i++) {
        //     nums[i] = 0;
        // }


        // Approach 2: Swapping Version (slightly trickier)
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero] = nums[i];
                nums[i] = temp;
                lastNonZero++;
            }
        }
    }
}