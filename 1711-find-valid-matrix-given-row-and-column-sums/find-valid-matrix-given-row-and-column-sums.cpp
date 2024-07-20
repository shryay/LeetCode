class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int rows = rowSum.size();
        int cols = colSum.size();
        vector<vector<int>> matrix(rows, vector<int>(cols, 0));
        
        int i = 0, j = 0;
        while (i < rows && j < cols) {
            int minSum = min(rowSum[i], colSum[j]);
            matrix[i][j] = minSum;
            rowSum[i] -= minSum;
            colSum[j] -= minSum;
            
            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }
        
        return matrix;
    }
};