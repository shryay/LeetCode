class Solution {
    public int strStr(String haystack, String needle) {

        // return haystack.indexOf(needle); 
        // simplest solution to this problem 

        // Otherwise we have to implement KMP algorithm

        int[] lps = computeLPSArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == needle.length())
                return i - j;
            else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    private int[] computeLPSArray(String needle) {
        int length = 0;
        int i = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } 
            else {
                if (length != 0)
                    length = lps[length - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}