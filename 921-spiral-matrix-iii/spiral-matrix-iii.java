class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalElements = rows * cols;
        int[][] result = new int[totalElements][2];
        result[0] = new int[] {rStart, cStart};
        if (totalElements == 1) {
            return result;
        }
        int index = 1;
        for (int k = 1; ; k += 2) {
            int[][] directions = new int[][] {
                {0, 1, k},
                {1, 0, k},
                {0, -1, k + 1},
                {-1, 0, k + 1}
            };
            for (int[] dir : directions) {
                int rowStep = dir[0], colStep = dir[1], steps = dir[2];
                while (steps-- > 0) {
                    rStart += rowStep;
                    cStart += colStep;
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[] {rStart, cStart};
                        if (index == totalElements) {
                            return result;
                        }
                    }
                }
            }
        }
    }
}