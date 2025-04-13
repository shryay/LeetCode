class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
        // // 1,2,3,4,5,6,7
        // // k = 3
        // // 5,6,7,1,2,3,4
        // // reverse = 7 6 5 4 3 2 1   step 1
        //              0 1 2 3 4 5 6
        //              k to n-1
        //                    k     ^
        //              7 6 5 1 2 3 4

        // 0 to k
        // 5 6 7 1 2 3 4 res
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}