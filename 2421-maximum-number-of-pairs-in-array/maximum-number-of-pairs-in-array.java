class Solution {
    public int[] numberOfPairs(int[] nums) {
        // Approach 1: Frequency Array + Odd/Even Check (Best)
        // Why Best? Input size and number range (0 ≤ nums[i] ≤ 100) are small.
        // Time: O(n), Space: O(1) (fixed-size array)
        int[] freq = new int[101];
        for (int num : nums) freq[num]++;
        int pairs = 0, leftovers= 0;
        for (int count : freq) {
            pairs += count / 2;
            leftovers += count % 2;
        }
        return new int[]{pairs, leftovers};
    }
}