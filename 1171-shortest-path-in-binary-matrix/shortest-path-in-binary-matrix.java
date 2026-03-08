class Solution {

    private static final int[][] DIR = {
        {1,1},{1,0},{1,-1},
        {0,1},{0,-1},
        {-1,1},{-1,0},{-1,-1}
    };

    private boolean isValid(int x, int y, int[][] grid) {
        int n = grid.length;
        return x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 1) return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{1, 0, 0});
        dist[0][0] = 1;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int d = curr[0], x = curr[1], y = curr[2];

            if (d > dist[x][y]) continue;

            for (int[] dir : DIR) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (!isValid(nx, ny, grid)) continue;

                if (d + 1 < dist[nx][ny]) {
                    dist[nx][ny] = d + 1;
                    pq.offer(new int[]{d + 1, nx, ny});
                }
            }
        }

        int ans = dist[n-1][n-1];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}