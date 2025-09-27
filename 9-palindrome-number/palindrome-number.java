class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
        return false;
        int r = 0;
        while (x > r) {
            int d = x % 10;
            r = r * 10 + d;
            x /= 10;
        }
        return x == r || x == r / 10;
    }
}