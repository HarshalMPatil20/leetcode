class Solution {
    public Map<Integer,List<int[]>> formatInput(int v, int [][] edges){
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int[] edge : edges){
            if(!adj.containsKey(edge[0])){
                adj.put(edge[0], new ArrayList<>());
            }
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        return adj;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,List<int[]>> adj = formatInput(n,times);

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        queue.add(new int[]{0,k});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int d = curr[0];
            int u = curr[1];

            if (d>dist[u]) continue;

            for(int[] node : adj.getOrDefault(u,new ArrayList<>())){
                int v = node[0];
                int weightUV = node[1];

                if(d + weightUV < dist[v]){
                    dist[v] = d + weightUV;
                    queue.add(new int[]{dist[v] , v});
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for(int i = 1; i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            res = Math.max(dist[i],res);
        }

        return res;
    }
}