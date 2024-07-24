class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] mappedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            mappedNums[i][0] = nums[i];
            mappedNums[i][1] = mapNumber(nums[i], mapping);
        }
        Arrays.sort(mappedNums, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = mappedNums[i][0];
        }
        return result;
    }
    private int mapNumber(int num, int[] mapping) {
        StringBuilder mapped = new StringBuilder();
        if (num == 0) {
            mapped.append(mapping[0]);
        } else {
            while (num > 0) {
                int digit = num % 10;
                mapped.append(mapping[digit]);
                num /= 10;
            }
            mapped.reverse();
        }
        return Integer.parseInt(mapped.toString());
    }
}