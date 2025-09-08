class Solution {
    public boolean isPalindrome(String s) {
        // // Optimal Approach using Two-pointers (Time: O(n), Space: O(1))
        // int left = 0, right = s.length() - 1;
        // while (left < right) {
        //     // Move left pointer until it's alphanumeric
        //     while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
        //     left++;
        //     // Move right pointer until it's alphanumeric
        //     while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
        //     right--;
        //     // Compare ignoring case
        //     if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
        //     return false;
        //     left++;
        //     right--;
        // }
        // return true;

        // // Regex + String Builder (simple, but Time: O(n), Space: O(n))
        // // Remove all non-alphanumeric characters & convert to lowercase
        // String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // // Reverse the cleaned string
        // String reversed = new StringBuilder(cleaned).reverse().toString();
        // // Compare original cleaned with reversed
        // return cleaned.equals(reversed);

        // Regex + 2-pointer (Time: 0(n), Space: O(n))
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i))
            return false;
        }
        return true;
    }
}