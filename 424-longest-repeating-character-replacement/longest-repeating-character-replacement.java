class Solution {
    public int characterReplacement(String s, int k) {
        int[] charFrequency = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int length = s.length();
        for (int right = 0; right < length; right++) {
            int currentCharIndex = s.charAt(right) - 'A';
            charFrequency[currentCharIndex]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[currentCharIndex]);
            int windowSize = right - left + 1;
            int charactersToReplace = windowSize - maxFrequency;
            if (charactersToReplace > k) {
                int leftCharIndex = s.charAt(left) - 'A';
                charFrequency[leftCharIndex]--;
                left++;
            }
        }
        return length - left;
    }
}