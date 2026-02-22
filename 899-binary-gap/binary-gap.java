class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int previousPosition = 100;
        int currentPosition = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                maxGap = Math.max(maxGap, currentPosition - previousPosition);
                previousPosition = currentPosition;
            }
            currentPosition++;
            n >>= 1;
        }
        return maxGap;
    }
}