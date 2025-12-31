class Solution {
    public long calculateThreshold (int[] nums,long divisor){
        int threshold = 0;

        for(int x : nums){
            threshold += (long) Math.ceil((double)x/divisor);
        }
        return threshold;
    }

    public long maxInArray( int[] arr){
        long max = Integer.MIN_VALUE;
        for( int x : arr ){
            max = Math.max(max , x);
        }
        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        long low = 1;
        long high = maxInArray(nums);

        long ans = 0;

        while(low<=high){

            long mid = low +(high-low)/2;
            
            long sum = calculateThreshold(nums,mid);

            if(threshold>=sum){
                ans = mid;
                high = mid - 1;
                
            }
            else{
                
                low = mid + 1;
            }
        }

        return (int)ans;
        
    }
}