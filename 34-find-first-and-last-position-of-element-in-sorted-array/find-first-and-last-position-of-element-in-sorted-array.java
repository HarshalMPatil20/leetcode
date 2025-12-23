class Solution {
    public int lowerbound(int [] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]>=x){
                ans=mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }
    public int upperbound(int [] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]>x){
                ans=mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {

        int [] res = new int[2];

        if(lowerbound(nums,target)==nums.length || nums[lowerbound(nums,target)]!=target){
            res[0]=-1;
            res[1]=-1;
            return res;
        }

        res[0]=lowerbound(nums,target);
        res[1]=upperbound(nums,target)-1;

        return res;


        
    }
}