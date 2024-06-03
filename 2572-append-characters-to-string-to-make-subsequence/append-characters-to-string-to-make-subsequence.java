class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0, x = s.length(), y = t.length();
        while (i < x && j < y) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return y - j;
    }
}