class Solution {
    public int subarraySum(int[] nums, int k) {
        // T.C : O(n)
        // S.C : O(n)
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
            result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}