class Solution {
    public List<String> commonChars(String[] words) {
        int minFreq[] = new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int charFreq[] = new int[26];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                charFreq[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charFreq[j]);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}