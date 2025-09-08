class Solution {
    public int maxArea(int[] height) {
        // // Simple Two-Pointer Approach
        // int i = 0, j = height.length - 1;
        // int maxWater = 0;
        // while (i < j) {
        //     int h = Math.min(height[i], height[j]);
        //     int w = j - i;
        //     maxWater = Math.max(maxWater, h * w);
        //     if (height[i] < height[j])
        //     i++;
        //     else
        //     j--;
        // }
        // return maxWater;


        // Approach 2: Skip Smaller Heights Faster
        int i = 0, j = height.length - 1;
        int maxWater = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            maxWater = Math.max(maxWater, h * w);
            // Skip all heights smaller than current h
            while (i < j && height[i] <= h) 
            i++;
            while (i < j && height[j] <= h)
            j--;
        }
        return maxWater;
    }
}