class Solution {
    public static final int[][] directions  = {
        {1,0},{-1,0},{0,1},{0,-1}
    };

    public static boolean isValid(int x, int y, int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        return x>=0 && y>=0 && x<m && y<n;
    }

    public int minimumEffortPath(int[][] heights) {

        int[][] dist = new int[heights.length][heights[0].length];
        for(int i = 0; i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        queue.add(new int[]{0,0,0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int d = curr[0];
            int Ux = curr[1];
            int Uy = curr[2];

            if(dist[Ux][Uy] < d){
                continue;
            }

            for(int [] direction : directions){

                int Vx = Ux + direction[0];
                int Vy = Uy + direction[1];

                if(!isValid(Vx,Vy,heights)){
                    continue;
                }

                int diff = Math.abs(heights[Ux][Uy] - heights[Vx][Vy]);
                int MaxDiff = Math.max(d,diff);
                
                if(dist[Vx][Vy] > MaxDiff){
                    dist[Vx][Vy] = MaxDiff;
                    queue.add(new int[]{MaxDiff,Vx,Vy});
                }
            }

        }
        
        return dist[dist.length-1][dist[0].length-1];


    }
}