class Solution {
    public int[] numberOfPairs(int[] nums) {
        // Approach 1: Frequency Array + Odd/Even Check (Best)
        // Why Best? Input size and number range (0 ≤ nums[i] ≤ 100) are small.
        // Time: O(n), Space: O(1) (fixed-size array)
        // int[] freq = new int[101];
        // for (int num : nums) freq[num]++;
        // int pairs = 0, leftovers= 0;
        // for (int count : freq) {
        //     pairs += count / 2;
        //     leftovers += count % 2;
        // }
        // return new int[]{pairs, leftovers};


        // Approach 2: HashMap + Odd/Even Counting
        // Useful if the number range wasn't fixed.
        // Time: O(n), Space: O(n)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        // int pairs = 0, leftovers = 0;
        // for (int count : map.values()) {
        //     pairs += count / 2;
        //     leftovers += count % 2;
        // }
        // return new int[]{pairs, leftovers};


        // Approach 3: HashSet
        // Time: O(n), Space: O(n)
        // Neat trick: a value in the set means it's unpaired.
        // Set<Integer> set = new HashSet<>();
        // int pairs = 0;
        // for (int num : nums) {
        //     if (set.contains(num)) {
        //         pairs++;
        //         set.remove(num); // Pair formed
        //     } 
        //     else {
        //         set.add(num);
        //     }
        // }
        // return new int[]{pairs, set.size()};


        // Approach 4: Sort + Scan
        // Time: O(n log n), Space: O(1) or O(n) depending on the sorting algorithm
        // Not optimal for this problem, but still valid.
        Arrays.sort(nums);
        int i = 0, pairs = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                pairs++;
                i += 2; // skip pair
            } 
            else {
                i++;
            }
        }
        int leftovers = nums.length - pairs * 2;
        return new int[]{pairs, leftovers};
    }
}