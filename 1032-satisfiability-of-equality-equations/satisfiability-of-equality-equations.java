class Solution {

    public int find(int node,int[] parent){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node],parent);
    }

    public void union(int x, int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);

        if(rank[x_parent] == rank[y_parent]){
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
        else if(rank[x_parent]>rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else{
            parent[x_parent] = y_parent;
        }
    }
    
    public boolean equationsPossible(String[] equations) {

        int[] parent = new int[26];
        int[] rank = new int[26];

        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }

        for(String s : equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent,rank);
            }
        }
        for(String s : equations){
            if(s.charAt(1)=='!'){
                if(find(s.charAt(0)-'a',parent) == find(s.charAt(3)-'a',parent)){
                    return false;
                };
            }
        }

        return true;
        
    }
}