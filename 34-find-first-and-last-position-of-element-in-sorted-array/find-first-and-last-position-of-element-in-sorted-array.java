class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStart(nums, target);
        result[1] = findEnd(nums, target);
        return result;
    }
    private int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
            }
            if (nums[mid] >= target)
            right = mid - 1;
            else
            left = mid + 1;
        }
        return start;
    }
    private int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                end = mid;
            }
            if (nums[mid] <= target)
            left = mid + 1;
            else
            right = mid - 1;
        }
        return end;
    }
}