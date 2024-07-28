class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[] {1, 0});
        int[][] distances = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[1][0] = 0;
        while (!queue.isEmpty()) {
            int[] nodeData = queue.pollFirst();
            int current = nodeData[0], distance = nodeData[1];
            for (int neighbor : graph[current]) {
                if (distance + 1 < distances[neighbor][0]) {
                    distances[neighbor][0] = distance + 1;
                    queue.offerLast(new int[] {neighbor, distance + 1});
                } 
                else if (distances[neighbor][0] < distance + 1 && distance + 1 < distances[neighbor][1]) {
                    distances[neighbor][1] = distance + 1;
                    if (neighbor == n) {
                        break;
                    }
                    queue.offerLast(new int[] {neighbor, distance + 1});
                }
            }
        }
        int totalTime = 0;
        for (int i = 0; i < distances[n][1]; ++i) {
            totalTime += time;
            if (i < distances[n][1] - 1 && (totalTime / change) % 2 == 1) {
                totalTime = (totalTime + change) / change * change;
            }
        }
        return totalTime;
    }
}