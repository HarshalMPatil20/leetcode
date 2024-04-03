class Solution {
    public boolean search(int i, int j, char [][] board , String word, int k, int [][] visited){

        // 1st Termination condition - if k is already completed through the "word"
        if (k == word.length()) return true;

        // 2nd termination condition - if pointer 'i' & 'j' reached the boundry of array or current character in 'word' is not at 
        // current array pointer location i.e. board[i][j] 
        if(i < 0 || j < 0 || i== board.length || j == board[0].length || board[i][j] != word.charAt(k) || visited[i][j]==1) return false;

        // Marked Visited place with '#' because not to visit again
        visited[i][j]=1;

        // 4 ways to search furthur
        boolean op1 = search(i+1,j,board,word,k+1,visited);
        boolean op2 = search(i,j+1,board,word,k+1,visited);
        boolean op3 = search(i-1,j,board,word,k+1,visited);
        boolean op4 = search(i,j-1,board,word,k+1,visited);

        // if in any case function fails, it again restores same character
        visited[i][j]=0;

        // Out of 4 , if any option succeeds , then return true.
        return op1 || op2 || op3 || op4;

    }


    public boolean exist(char[][] board, String word) {

        int [][] visited = new int[board.length][board[0].length];  

        for(int i=0; i< board.length; i++){
            for(int j=0 ; j < board[0].length; j++){
                if(search(i,j,board,word,0,visited)) return true;
            }
        }
      return false;
        
    }
}