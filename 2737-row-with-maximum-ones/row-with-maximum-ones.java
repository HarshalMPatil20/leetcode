class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {

        int maxi = 0;
        int index = 0;

        for(int i=0; i<mat.length;i++){
            int count = 0;
            for(int ele : mat[i]){
                count += ele;
            }

            if(count>maxi){
                index = i;
                maxi = count;
            }
        }

        return new int[] {index,maxi};
        
    }
}