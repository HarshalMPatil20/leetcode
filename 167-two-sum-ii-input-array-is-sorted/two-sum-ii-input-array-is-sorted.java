class Solution {
    public int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==target) return mid;
            else if(arr[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int low = 0;
        int high = numbers.length-1;
        int lowest = numbers[0];
        int highest = numbers[numbers.length-1];

        // while(low<=high){
        //     int mid = low + (high-low)/2;
        //     int counter_mid = binarySearch(numbers,target-numbers[mid]);

        //     if(counter_mid!=-1 && mid!=counter_mid){
        //         ans[0] = Math.min(mid+1,counter_mid+1);
        //         ans[1] = Math.max(mid+1,counter_mid+1);

        //         return ans;
        //     }
        //     else if(numbers[mid] + highest < target  ){
        //         low = mid + 1;
        //     }
        //     else{
        //         high = mid - 1;
        //     }
        // }

        for(int i=0;i<numbers.length;i++){

            int counter_mid = binarySearch(numbers,target-numbers[i]);

            if(counter_mid!=-1 && i!=counter_mid){
                ans[0] = Math.min(i+1,counter_mid+1);
                ans[1] = Math.max(i+1,counter_mid+1);

                return ans;
            }

        }

        return new int[]{-1,-1};
    }

    
}