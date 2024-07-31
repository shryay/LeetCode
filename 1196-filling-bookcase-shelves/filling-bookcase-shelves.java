class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int numOfBooks = books.length;
        int[] dp = new int[numOfBooks + 1];
        for (int i = 1; i <= numOfBooks; ++i) {
            int currentWidth = books[i - 1][0];
            int currentHeight = books[i - 1][1];
            dp[i] = dp[i - 1] + currentHeight;
            for (int j = i - 1; j > 0; --j) {
                currentWidth += books[j - 1][0];
                if (currentWidth > shelfWidth) {
                    break;
                }
                currentHeight = Math.max(currentHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + currentHeight);
            }
        }
        return dp[numOfBooks];
    }
}