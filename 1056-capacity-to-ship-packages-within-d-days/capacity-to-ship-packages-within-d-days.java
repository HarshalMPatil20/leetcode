class Solution {
    public long[] maxAndSumofArray(int[] arr) {
        long[] ans = new long[2];
        ans[0] = Long.MIN_VALUE;

        for (int x : arr) {
            ans[0] = Math.max(ans[0], x);
            ans[1] += x;
        }

        return ans;
    }

    public long calculateDays(int[] weights, long capacity) {

        // Why do we start with days = 1?
        //Because even before processing any weight, you are already on the first day.

        long days = 1;
        long currWeight = 0;

        for (int x : weights) {
            
            if(currWeight + x > capacity){
               // go to next day
                days++;
                currWeight = x;
            }
            else{
                currWeight += x;
            }

        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        long[] arr = maxAndSumofArray(weights);

        if(days==1) return (int)arr[1];
        if(days==weights.length) return (int)arr[0];

        long low = arr[0];
        long high = arr[1];

        long ans = 0;

        while(low<=high){
            long mid = low+(high-low)/2;
            long calculatedDays = calculateDays(weights,mid);

            if(calculatedDays<=days){
                ans = mid;
                high = mid -1;
               
            }
            else{
                low = mid + 1; 
            }
        }

        return (int)ans;

    }
}