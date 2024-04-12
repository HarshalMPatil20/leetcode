class Solution {
    public int trap(int[] height) {

       int n = height.length;

        int left = 0; 
        int right = n - 1;
        int res = 0;
        int maxLeft = 0; 
        int maxRight = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } 
                else {
                    res += maxLeft - height[left];
                }
                left++;
            } 
            else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } 
                else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // int result = 0;
        // int left = 0;
        // int right = 0;
        // int sub = 0;
        // int counter = 0;
 

        // while(left < height.length-1){
        //     if(height[left] > height[left+1]){
        //         right = left+1;
        //         while(right<height.length-1 && (height[right]<height[right-1] || height[right]<height[right+1]) ){
        //             sub += height[right];
        //             counter++;
        //             right++;
        //         }

        //         result += Math.min(height[left],height[right]) * counter - sub;
        //         counter = 0;
        //         sub=0;
        //         left=right;
        //     }
        //     else{
        //         left++;
        //     }
            
        // }

        // return result;
        
    }
}