class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secLargest = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (digit > largest) {
                    secLargest = largest;
                    largest = digit;
                }
                else if (digit > secLargest && digit != largest)
                secLargest = digit;
            }
        }
        if (secLargest != -1)
        return secLargest;
        else
        return -1;
    }
}