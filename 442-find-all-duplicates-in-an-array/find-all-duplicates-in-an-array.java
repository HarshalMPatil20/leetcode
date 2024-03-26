class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // here we will use negative sign as a marked position signature
        // we will mark the preffered position of element as negative 
        // if the element again occurs and its position is negative element then its duplicate
        // but while traversing we have to keep in mind that the element can already be marked as negative
        // this we create error
        // so we have to search every elemnts position using its absolute value
        // position = Math.abs(element)-1

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            int index = Math.abs(element) -1;
            
            if(nums[index]<0) {ans.add(Math.abs(element));}

            nums[index] = - nums[index];

        }
        return ans;
        
    }
}