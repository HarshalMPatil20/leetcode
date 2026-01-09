class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        int ans = Integer.MAX_VALUE;

        if(nums.length == 1) return nums[0];

        if(nums.length == 2) return Math.min(nums[low],nums[high]);
        
        
        while(low<=high){
            int mid = low+(high-low)/2;

            while( high-low >= 2 && nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low]<nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }
            else if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high =  mid - 1;
            }

        }

        return ans ;
        
    }
}