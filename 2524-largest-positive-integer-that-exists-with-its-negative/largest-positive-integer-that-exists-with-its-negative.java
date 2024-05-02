class Solution {
    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++){
             map.put(nums[i], 0);
        }

        int max = -1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(0-nums[i])){
                max = Math.max(max,Math.abs(nums[i]));
            }
        }
        return max;

        
    }
}