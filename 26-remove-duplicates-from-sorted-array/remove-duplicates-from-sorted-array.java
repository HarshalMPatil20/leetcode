class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;
        int count = 1;

        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                count++;
                i++;
            }
            j++;
        }
        return count;
        
    }
}