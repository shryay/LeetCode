class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int right = n - 1;
        int left = 0;
        while (left <= right) {
            if (nums[left] == val) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            else
            left++;
        }
        return left;
    }
}