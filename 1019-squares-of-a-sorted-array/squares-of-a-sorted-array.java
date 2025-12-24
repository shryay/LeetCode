class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0,
        right = nums.length - 1,
        idx = nums.length - 1;
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                res[idx--] = leftSq;
                left++;
            }
            else {
                res[idx--] = rightSq;
                right--;
            }
        }
        return res;
    }
}