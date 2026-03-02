class Solution {
    public void DFS(int node, boolean[] visited,int[][] isConnected){
        visited[node] = true;

        for(int i=0;i<isConnected.length;i++){
            if((isConnected[node][i] == 1) && (!visited[i])){
                DFS(i,visited,isConnected);
            }
        }
    }

    public void BFS(int node, boolean[] visited,int[][] isConnected){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        
        while(!queue.isEmpty()){

            int parent = queue.poll();
            visited[parent] = true;

            for(int i = 0; i<isConnected.length; i++){
                if((isConnected[parent][i] == 1) && (!visited[i])){
                    queue.add(i);
                }
            }

        }

    }
    public int findCircleNum(int[][] isConnected) { 

        int provinces = 0;

        boolean[] visited = new boolean[isConnected.length];

        for(int i = 0; i<visited.length; i++){
            if(!visited[i]){
                provinces++;
                BFS(i,visited,isConnected);
            }
        }

        return provinces;

    }
}