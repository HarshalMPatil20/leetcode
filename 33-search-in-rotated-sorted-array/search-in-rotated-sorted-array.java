class Solution {
    public int BinarySearch(int[] arr,int Low,int High, int x){
        int low = Low;
        int high = High;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]==x) return mid;
            else if(arr[mid]<x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return -1;

    }
    public int search(int[] nums, int target) {

        if(nums.length==1){
            if(nums[0]==target) return 0;
            else return -1;
        }

        int breaking_point = 0;

        while(breaking_point+1<nums.length){
            if(nums[breaking_point]>nums[++breaking_point]) break;
        }

        if(BinarySearch(nums,0,breaking_point-1, target)!=-1){
            return BinarySearch(nums,0,breaking_point-1, target);
        }
        else{
            return BinarySearch(nums,breaking_point,nums.length-1,target);
        }

      

        
    }
}