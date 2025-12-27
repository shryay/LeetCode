class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }
            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + duration;
                busy.offer(new long[]{newEnd, earliest[1]});
                count[(int) earliest[1]]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}