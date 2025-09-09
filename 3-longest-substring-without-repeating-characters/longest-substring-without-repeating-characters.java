class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r)))
            l = Math.max(l, map.get(s.charAt(r)) + 1);
            map.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}