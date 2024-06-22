class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
         return sb.toString();
    }
     private static void quickSort(String[] strs, int low, int high) {
        if (low < high) {
            int pi = partition(strs, low, high);
            quickSort(strs, low, pi - 1);
            quickSort(strs, pi + 1, high);
        }
    }
    private static int partition(String[] strs, int low, int high) {
        String pivot = strs[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            String ab = strs[j] + pivot;
            String ba = pivot + strs[j];
            if (ab.compareTo(ba) > 0) {
                i++;
                swap(strs, i, j);
            }
        }
        swap(strs, i + 1, high);
        return i + 1;
    }
    private static void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}