class Solution {
    public int calculateThreshold (int[] nums,int divisor){
        int threshold = 0;

        for(int x : nums){
            threshold += (int) Math.ceil((double)x/divisor);
        }
        return threshold;
    }

    public int maxInArray( int[] arr){
        int max = Integer.MIN_VALUE;
        for( int x : arr ){
            max = Math.max(max , x);
        }
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = maxInArray(nums);

        int ans = 0;

        while(low<=high){

            int mid = low +(high-low)/2;
            
            int sum = calculateThreshold(nums,mid);

            if(threshold>=sum){
                ans = mid;
                high = mid - 1;
                
            }
            else{
                
                low = mid + 1;
            }
        }

        return ans;
        
    }
}