class Solution {
    public boolean check(int[] nums) {

        int minidx =0;

        int count=0;
        while(count<=nums.length-1){
            if(nums[count%nums.length]>nums[(count+1)%nums.length]){                     
                minidx++;
            }
            count++;
        }
        return (minidx<=1)?true:false;

        
    }
}