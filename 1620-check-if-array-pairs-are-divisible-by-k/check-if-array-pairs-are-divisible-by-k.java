class Solution {
    public boolean canArrange(int[] arr, int k) {
        int nums[] = new int[k];
        for (int i = 0; i< arr.length; i++) {
            int rem = (arr[i] % k + k) % k;
            nums[rem]++;
        }
        if (nums[0] % 2 != 0) 
        return false;
        for (int i = 1; i <= k / 2; i++) {
            if (nums[i] != nums[k-i]) 
            return false;
        }
        return true;
    }
}