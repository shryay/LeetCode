class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;
        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> participants = new HashSet<>();
            while (i < meetings.length && meetings[i][2] == time) {
                int u = meetings[i][0];
                int v = meetings[i][1];
                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
                participants.add(u);
                participants.add(v);
                i++;
            }
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int p : participants) {
                if (knows[p]) {
                    queue.offer(p);
                    visited.add(p);
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            for (int p : visited) {
                knows[p] = true;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knows[p]) result.add(p);
        }
        return result;
    }
}