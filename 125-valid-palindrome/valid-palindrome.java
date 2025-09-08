class Solution {
    public boolean isPalindrome(String s) {
        // Optimal Approach using Two-pointers (Time: O(n), Space: O(1))
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Move left pointer until it's alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            left++;
            // Move right pointer until it's alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
            right--;
            // Compare ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            return false;
            left++;
            right--;
        }
        return true;
    }
}