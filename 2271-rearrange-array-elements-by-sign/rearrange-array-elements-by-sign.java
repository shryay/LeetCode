class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Separate positives and negatives
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int p = 0, q = 0;
        
        for (int num : nums) {
            if (num > 0) {
                pos[p++] = num;
            } else {
                neg[q++] = num;
            }
        }
        
        // Merge alternately
        int i = 0, j = 0, k = 0;
        while (i < n/2 && j < n/2) {
            result[k++] = pos[i++];
            result[k++] = neg[j++];
        }
        
        return result;
    }
}