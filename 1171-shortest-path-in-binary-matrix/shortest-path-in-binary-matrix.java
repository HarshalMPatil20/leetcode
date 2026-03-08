class Solution {
    public boolean isValid(int x, int y, int[][] grid) {
        if ((x < 0) || (x >= grid.length)) {
            return false;
        }
        if ((y < 0) || (y >= grid.length)) {
            return false;
        }
        if (grid[x][y] != 0) {
            return false;
        }
        return true;
    }

    public List<int[]> provideNeighbours(int x, int y, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        int[][] direction = new int[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
                { -1, -1 } };

        for (int[] offset : direction) {
            if (isValid(x + offset[0], y + offset[1], grid)) {
                neighbours.add(new int[] { x + offset[0], y + offset[1] });
            }
        }
        return neighbours;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;

        int[][] dist = new int[grid.length][grid[0].length];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        queue.add(new int[] { 1, 0, 0 });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int d = curr[0];
            int Ux = curr[1];
            int Uy = curr[2];

            if (d > dist[Ux][Uy]) {
                continue;
            }

            for (int[] node : provideNeighbours(Ux, Uy, grid)) {

                int Vx = node[0];
                int Vy = node[1];

                if (d + 1 < dist[Vx][Vy]) {
                    dist[Vx][Vy] = d + 1;
                    queue.add(new int[] {dist[Vx][Vy], Vx, Vy });
                }

            }

        }

    
        if (dist[grid.length - 1][grid[0].length - 1] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[grid.length - 1][grid[0].length - 1];

    }
}