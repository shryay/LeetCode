class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        boolean[] sorted = new boolean[rows - 1];
        int deletions = 0;
        for (int c = 0; c < cols; c++) {
            boolean delete = false;
            for (int r = 0; r < rows - 1; r++) {
                if (!sorted[r] &&
                    strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    delete = true;
                    break;
                }
            }
            if (delete) {
                deletions++;
                continue;
            }
            for (int r = 0; r < rows - 1; r++) {
                if (!sorted[r] &&
                    strs[r].charAt(c) < strs[r + 1].charAt(c)) {
                    sorted[r] = true;
                }
            }
        }
        return deletions;
    }
}