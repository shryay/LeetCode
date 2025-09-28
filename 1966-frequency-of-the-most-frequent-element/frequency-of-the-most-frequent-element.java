class Solution {
    public int maxFrequency(int[] nums, int k) {
        
    //     // Approach-1 (Using Binary Search)
    //     // T.C : O(nlogn)
    //     // S.C : O(n) for prefixSum for effienctly calculating windowSum

    //     int n = nums.length;
        
    //     Arrays.sort(nums);
    //     long[] prefixSum = new long[n];
    //     prefixSum[0] = nums[0];
        
    //     for (int i = 1; i < n; i++) {
    //         prefixSum[i] = prefixSum[i - 1] + nums[i];
    //     }
        
    //     int result = 0;
        
    //     for (int i = 0; i < n; i++) {
    //         result = Math.max(result, findBest(i, k, nums, prefixSum));
    //     }
        
    //     return result;
    // }
    // private int findBest(int targetIdx, int k, int[] nums, long[] prefixSum) {
    //     int target = nums[targetIdx];
        
    //     int i = 0;
    //     int j = targetIdx;
    //     int result = targetIdx;
        
    //     while (i <= j) {
    //         int mid = i + (j - i) / 2;
            
    //         long count = (targetIdx - mid + 1);
    //         long windowSum = (count * target);
    //         long currSum = prefixSum[targetIdx] - prefixSum[mid] + nums[mid];
            
    //         int ops = (int) (windowSum - currSum);
            
    //         if (ops > k) {
    //             i = mid + 1;
    //         } else {
    //             result = mid;
    //             j = mid - 1;
    //         }
    //     }
        
    //     return targetIdx - result + 1;


        // Approach-2 (Using sliding window)
        // T.C : O(nlogn)
        // S.C : O(1)
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int result = 0;
        
        int i = 0;
        long currSum = 0;
        
        for (int j = 0; j < n; j++) {
            
            long target = nums[j];
            currSum += nums[j];
            
            while ((j - i + 1) * target - currSum > k) {
                currSum -= nums[i];
                i++;
            }
            
            result = Math.max(result, j - i + 1);
            
        }
        return result;
    }
}