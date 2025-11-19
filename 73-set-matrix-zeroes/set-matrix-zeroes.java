class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for(int m=0;m<matrix.length;m++){
            for(int n=0;n<matrix[0].length;n++){
                if(matrix[m][n]==0){
                    row.add(m);
                    column.add(n);
                }
            }
        }

        for(int m=0;m<matrix.length;m++){
            for(int n=0;n<matrix[0].length;n++){
                if(matrix[m][n]!=0 && (row.contains(m) || column.contains(n))){
                   matrix[m][n]=0;
                }
            }
        }
        
    }
}