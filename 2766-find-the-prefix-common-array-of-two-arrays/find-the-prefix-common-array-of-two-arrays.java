class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int cnt = 0;
        int[] C = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) == 2)
            cnt++;
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if (map.get(B[i]) == 2)
            cnt++;
            C[i] = cnt;
        }
        return C;
    }
}