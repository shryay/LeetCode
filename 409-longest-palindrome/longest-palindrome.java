class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        int length = 0;
        for (int i : count) {
            length += (i / 2) * 2;
            if (i % 2 == 1 && length % 2 == 0)
            length++;
        }
        return length;
    }
}