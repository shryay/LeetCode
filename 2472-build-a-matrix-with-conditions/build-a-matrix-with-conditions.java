class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        return matrix;
    }
    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] condition : conditions) {
            graph[condition[0]].add(condition[1]);
            inDegree[condition[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if (topologicalOrder.size() != k) {
            return null;
        }
        return topologicalOrder;
    }
}