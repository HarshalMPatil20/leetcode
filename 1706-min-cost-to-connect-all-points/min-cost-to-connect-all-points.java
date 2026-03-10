class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int V) {
            parent = new int[V];
            rank = new int[V];

            for (int i = 0; i < V; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        boolean union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) {
                return false; // already connected
            }

            if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if (rank[y_parent] > rank[x_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }

            return true;
        }
    }

    public List<int[]> generateEdges(int[][] points) {

        List<int[]> edges = new ArrayList<>();
        int n = points.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int Ux = points[i][0];
                int Uy = points[i][1];
                int Vx = points[j][0];
                int Vy = points[j][1];

                int manhattan = Math.abs(Ux - Vx) + Math.abs(Uy - Vy);
                edges.add(new int[] { manhattan, i, j });
            }
        }

        return edges;
    }

    public int minCostConnectPoints(int[][] points) {

        List<int[]> edges = generateEdges(points);

        edges.sort(Comparator.comparingInt(a -> a[0]));

        int minCost = 0;
        int edgesUsed = 0;
        int V = points.length;

        DSU dsu = new DSU(V);

        for (int[] edge : edges) {

            int w = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (dsu.union(u, v)) {
                minCost += w;
                edgesUsed++;
            }

            if (edgesUsed == V - 1) {
                break;
            }
        }

        return minCost;

    }
}