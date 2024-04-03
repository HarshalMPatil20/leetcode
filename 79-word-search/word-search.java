class Solution {

    public boolean search(int i, int j, char [][] board , String word, int k){

     // 1st Termination condition - if k is already completed through the "word"
        if (k == word.length()) return true;

    // 2nd termination condition - if pointer 'i' & 'j' reached the boundry of array or current character in 'word' is not at 
    // current array pointer location i.e. board[i][j] 
        if(i < 0 || j < 0 || i== board.length || j == board[0].length || board[i][j] != word.charAt(k)) return false;

    // Marked Visited place with '#' because not to visit again
        board[i][j]='#';

    // 4 ways to search furthur
        boolean op1 = search(i+1,j,board,word,k+1);
        boolean op2 = search(i,j+1,board,word,k+1);
        boolean op3 = search(i-1,j,board,word,k+1);
        boolean op4 = search(i,j-1,board,word,k+1);

    // if in any case function fails, it again restores same character
        board[i][j] = word.charAt(k);

    // Out of 4 , if any option succeeds , then return true.
        return op1 || op2 || op3 || op4;

    }


    public boolean exist(char[][] board, String word) {

        for(int i=0; i< board.length; i++){
            for(int j=0 ; j < board[0].length; j++){

    // Start search function at every 
                if(search(i,j,board,word,0)) return true;
            }
        }
      return false;
        
    }
}