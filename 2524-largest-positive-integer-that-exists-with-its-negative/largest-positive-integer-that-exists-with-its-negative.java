class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length;i++){
             set.add(nums[i]);
        }

        int max = -1;
        for(int i=0;i<nums.length;i++){
            if(set.contains(0-nums[i])){
                max = Math.max(max,Math.abs(nums[i]));
            }
        }
        return max;

        
    }
}