class Solution {
    public void swap(int[][]arr,int r1,int c1, int r2, int c2,int r3,int c3, int r4, int c4){
        int temp = arr[r4][c4];
        arr[r4][c4] = arr[r3][c3];
        arr[r3][c3] = arr[r2][c2];
        arr[r2][c2] = arr[r1][c1];
        arr[r1][c1] = temp;
    }     
    public void rotate(int[][] matrix) {
        int l = matrix.length-1;

        for(int m=0 ; m<=l; m++){
            for(int n=m ; n<l-m; n++){
                swap(matrix,m,n,n,l-m,l-m,l-n,l-n,m);
            }

        }
        
    }
}