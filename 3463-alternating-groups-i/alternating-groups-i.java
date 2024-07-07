class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int prevColor = colors[(i - 1 + n) % n];
            int nextColor = colors[(i + 1) % n];
            int currentColor = colors[i];
            if (currentColor != prevColor && currentColor != nextColor && prevColor == nextColor) {
                count++;
            }
        }
        return count;
    }
}