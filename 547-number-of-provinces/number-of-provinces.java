class Solution {
    public void DFS(int node, int[] visited,int[][] isConnected){
        visited[node] = 1;

        for(int i=0;i<isConnected.length;i++){
            if((isConnected[node][i] == 1) && (visited[i] == 0)){
                DFS(i,visited,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) { 

        int provinces = 0;

        int[] visited = new int[isConnected.length];

        for(int i = 0; i<visited.length; i++){
            if(visited[i] == 0){
                provinces++;
                DFS(i,visited,isConnected);
            }
        }

        return provinces;

    }
}