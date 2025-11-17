class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int max_water = 0;
        int curr_water = 0;

        while ( lp < rp){
            curr_water = Math.min(height[lp],height[rp])*(rp-lp);
            max_water = Math.max(max_water,curr_water);
            if(height[lp]<height[rp]){
                lp++;
            }
            else{
                rp--;
            }
        }
        return max_water;
    }
}