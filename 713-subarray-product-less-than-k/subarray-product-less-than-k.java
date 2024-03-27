class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Sliding Window Approach
        int product =1;
        int ans=0;
        int end=0;
        int start=0;

        if(k<=1) return 0;

        while(end < nums.length){
            product *= nums[end];

            while( product >= k ){
                product = product/nums[start];
                start++;
            }
            
            ans += end-start+1;
             end++;
        }
        return ans;
    }
}