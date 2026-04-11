class Solution {
    public int maxOperations(String s) {
        int totalOperations = 0;
        int onesCount = 0;
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '1') {
                onesCount++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                totalOperations += onesCount;
            }
        }
        return totalOperations;
    }
}