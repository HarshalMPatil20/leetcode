class Solution {
    public int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        int[] source = points[0];

        boolean[] visited = new boolean[points.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[] { 0, source[0], source[1], 0 }); // {dist,Ux,Uy,idxInPoints}

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int idx = curr[3];
            if (visited[idx])
                continue;

            int weight = curr[0];
            int Ux = curr[1];
            int Uy = curr[2];

            minCost += weight;
            visited[idx] = true;

            for (int i = 0; i < points.length; i++) {

                if(!visited[i]){
                    int Vx = points[i][0];
                    int Vy = points[i][1];
                    int manhattanDist = Math.abs(Ux-Vx) + Math.abs(Uy-Vy);

                    queue.add(new int[]{manhattanDist,Vx,Vy,i}); 
                }
            }

        }

        return minCost;

    }
}