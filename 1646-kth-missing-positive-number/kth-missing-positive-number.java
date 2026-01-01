class Solution {
    public int findKthPositive(int[] arr, int k) {

        if(arr[0]-1>=k) return k;

        if(arr[arr.length-1]-(arr.length)<k) return (k+(arr.length));

        int low = 0;
        int high = arr.length-1;

        int offset = 0;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]-mid-1 < k){
                offset = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return k + offset + 1;

    }
}