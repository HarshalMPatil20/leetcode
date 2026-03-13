class Solution {

    Map<Integer, Deque<Integer>> graph = new HashMap<>();
    List<Integer> path = new ArrayList<>();

    void dfs(int node) {
        Deque<Integer> edges = graph.get(node);

        while (edges != null && !edges.isEmpty()) {
            dfs(edges.poll());
        }

        path.add(node);
    }

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, Integer> balance = new HashMap<>();

        for (int[] e : pairs) {
            graph.computeIfAbsent(e[0], k -> new ArrayDeque<>()).add(e[1]);

            balance.put(e[0], balance.getOrDefault(e[0], 0) + 1);
            balance.put(e[1], balance.getOrDefault(e[1], 0) - 1);
        }

        int start = pairs[0][0];

        for (int node : balance.keySet()) {
            if (balance.get(node) == 1) {
                start = node;
                break;
            }
        }

        dfs(start);
        Collections.reverse(path);

        int[][] res = new int[pairs.length][2];

        for (int i = 0; i < pairs.length; i++) {
            res[i][0] = path.get(i);
            res[i][1] = path.get(i + 1);
        }

        return res;
    }
}