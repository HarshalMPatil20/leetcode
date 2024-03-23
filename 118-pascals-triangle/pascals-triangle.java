class Solution {

    public List<Integer> generateRows (int row){
        int element = 1;
        // In java while Initialize the List
        // Object is created 
        List<Integer> ansRow = new ArrayList<Integer>(); 
        ansRow.add(element);
        for(int i=1; i<row; i++){
            element = element * (row-i);
            element = element / i;
            ansRow.add(element);
        } 
        return ansRow;
    }
    public List<List<Integer>> generate(int numRows) {
        // This is how we Initialize list of lists
        List<List<Integer>> Ans = new ArrayList<List<Integer>>(); 
        
        for(int i=1; i<= numRows; i++){
            Ans.add(generateRows(i));
        }
        return Ans;
    }
}