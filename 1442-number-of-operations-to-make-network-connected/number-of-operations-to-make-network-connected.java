class Solution {
    public int find(int node, int[] parent){
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node],parent);
    }

    public boolean union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);

        if(x_parent == y_parent){
            return false;
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

        return true;
    }
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1){
            return -1;
        }

        int [] parent = new int[n];
        int [] rank = new int[n];
        int groups = n;

        for(int i=0; i<parent.length;i++){
            parent[i] = i;
        }

        for(int[] arr : connections){
            if(union(arr[0],arr[1],parent,rank)){
                groups--;
            }
        }

        return groups-1;
        
    }
}