class Solution {

    public void DFS(int node, Map<Integer, List<Integer>> adj, Stack<Integer> stack) {
        List<Integer> list = adj.get(node);

        while (list != null && !list.isEmpty()) {
            int neighbour = list.remove(list.size() - 1);
            DFS(neighbour, adj, stack);
        }

        stack.push(node);
    }

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, int[]> degree = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int[] edge : pairs) {

            adj.computeIfAbsent(edge[0], k -> new ArrayList<>());
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>());

            degree.computeIfAbsent(edge[0], k -> new int[2]);
            degree.computeIfAbsent(edge[1], k -> new int[2]);

            adj.get(edge[0]).add(edge[1]);

            degree.get(edge[0])[1]++;
            degree.get(edge[1])[0]++;
        }

        int source = pairs[0][0];

        for (int node : degree.keySet()) {
            if (degree.get(node)[1] - degree.get(node)[0] == 1) {
                source = node;
                break;
            }
        }

        DFS(source, adj, stack);

        List<Integer> order = new ArrayList<>(stack);
        Collections.reverse(order);

        int[][] res = new int[pairs.length][2];

        for (int i = 0; i < pairs.length; i++) {
            res[i][0] = order.get(i);
            res[i][1] = order.get(i + 1);
        }

        return res;
    }
}