class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hasEvenNumberOfDigits(nums[i]))
                evenCount++;
        }
        return evenCount++;
    }
    private boolean hasEvenNumberOfDigits(int num) {
        int digitCount = 0;
        while (num != 0) {
            num = num / 10;
            digitCount++;
        }
        return digitCount % 2 == 0;
    }
}