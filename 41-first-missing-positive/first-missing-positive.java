class Solution {
    public static void swap(int[] arr, int i, int j) {
    arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}
   
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // if the size of array is num.length 
        // the range of first missing positive integer should be [1 , (num.length + 1)]

        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            

            if(element>=1 && element <= n)
           { int position = element-1; 
            if(element != nums[position]){
                swap(nums,position,i);
                i--;
            }
           }
        }

        for(int i=0;i<nums.length;i++){
            if(i+1 != nums[i])return i+1;
        }
    return n+1;
        
    }
}