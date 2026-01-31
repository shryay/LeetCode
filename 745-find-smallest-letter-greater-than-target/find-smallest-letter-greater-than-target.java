class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0;
        int right = n - 1;
        int firstTrueIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (firstTrueIndex == -1) {
            return letters[0];
        }
        return letters[firstTrueIndex];
    }
}