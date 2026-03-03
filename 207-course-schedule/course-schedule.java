class Solution {
    public List<Integer> hasCycleBFS(Map<Integer, List<Integer>> adj, int[] Indegree) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> toposort = new ArrayList<>();

        for (int i = 0; i < Indegree.length; i++) {
            if (Indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            toposort.add(node);

            for (int i : adj.getOrDefault(node, new ArrayList<>())) {
                Indegree[i]--;
                if (Indegree[i] == 0) {
                    queue.add(i);
                }
            }

        }

        return toposort;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] Indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
            Indegree[arr[1]]++;
        }

        List<Integer> toposort = hasCycleBFS(adj, Indegree);

        if (toposort.size() == numCourses)
            return true;

        return false;

    }
}