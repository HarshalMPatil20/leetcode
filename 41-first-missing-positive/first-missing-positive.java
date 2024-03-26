class Solution {

    public static void swap(int[] arr, int i, int j) {
    arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}
   
    public int firstMissingPositive(int[] nums) {
        
        // If the size of array is num.length 
        // the range of first missing positive integer should be [1 , (num.length + 1)]

        // Ignore Three (3) types of element in the array
        // 1. 0 
        // 2. Negative Numbers
        // 2. Numbers greater than nums.length +1

        //Two things are used:
        // 1.element 
        // 2.its Position (nums[element-1]....as indexing starts from zero)
        // ex. if element is 2, then its position index in the array should be 1 (2-1)

// Step 1: Reposition Element to its preffered position

        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            
            // check only if element is positive and less than nums.length + 1
            // otherwise ignore for swapping as they can't be solution
            if(element>=1 && element <= nums.length){

                //position is the preffered index of element in the array 
                 int position = element-1;

                // if element is not on its position 
                if(element != nums[position]){

                // reposition it with swapping the element with its position
                swap(nums,position,i);

                //take pointer backwards as there can be change behind the current traversal
                i--;
            }
           }
        }

// Step 2: Identify Missing element 

        // Now elements are repositioned
        for(int i=0;i<nums.length;i++){
            //If element is missing from its preffered position then its our missing element
            if(i+1 != nums[i])return i+1;
        }
        // if none is missing, first element after the indexing i.e. (nums.length + 1) is our missing element
        return nums.length+1;
        
    }
}