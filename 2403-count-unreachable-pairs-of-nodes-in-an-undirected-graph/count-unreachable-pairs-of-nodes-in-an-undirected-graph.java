class Solution {
    public int find(int node, int[] parent){
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] == rank[y_parent]){
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
        else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else{
            parent[x_parent] = y_parent;
        }
    }

    public long combinations(int x){
        if(x<2) return 0;
        
        long ans = 0;

        if(x%2 == 0){
            ans += x >> 1;
            ans *= (x-1);
        }
        else{
            ans += (x-1) >> 1;
            ans *= x; 
        }
        
        return ans;
    }

    public long countPairs(int n, int[][] edges) {
    

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i<parent.length;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1], parent,rank);
        }

        Map<Integer,Integer> group = new HashMap<>();

        for(int i = 0; i<n; i++){
            int i_leader = find(i,parent);
            group.put(i_leader,group.getOrDefault(i_leader,0)+1);
        }

        long total_pairs = combinations(n);

        for(int i :group.keySet()){
            total_pairs -= combinations(group.get(i));
        }

        return total_pairs;
        
    }
}