class Solution {
    public void swap(int[]arr,int x,int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y]=temp;
    }
    public void sortColors(int[] nums) {
        int low =0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }

        }
        
    }
}