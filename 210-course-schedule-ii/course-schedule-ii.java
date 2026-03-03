class Solution {
    public List<Integer> BFS(Map<Integer, List<Integer>> adj, int[] Indegree) {

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] Indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            adj.get(arr[0]).add(arr[1]);
            Indegree[arr[1]]++;
        }

        List<Integer> toposort = BFS(adj, Indegree);

        if (toposort.size() == numCourses) {
            Collections.reverse(toposort);
            return toposort.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        return new int[] {};

    }
}