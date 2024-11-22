class Solution {
    public void swap(int[]arr,int x,int y){
        int temp= arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    public void reverse(int[] arr, int x, int y){
        while(x<y){
            swap(arr,x,y);
            x++;
            y--;
        }
    }

    public void nextPermutation(int[] nums) {
        int breaking=0;

        for(int i=nums.length-2;i>=-1;i--){
            if(i==-1){
                reverse(nums,0,nums.length-1);
                return;
            }
            if(nums[i]<nums[i+1]){
                breaking=i;
                break;
            }
        }

        for(int i=nums.length-1;i>breaking;i--){
            if(nums[i]>nums[breaking]){
                swap(nums,i,breaking);
                break;
            }
        }

        reverse(nums,breaking+1,nums.length-1);

    }
}