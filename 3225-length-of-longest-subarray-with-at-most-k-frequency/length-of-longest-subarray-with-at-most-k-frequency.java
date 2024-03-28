class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int Left_pointer = 0;
        int answer = 0;

        for(int Right_pointer = 0; Right_pointer<nums.length; Right_pointer++){
            
            map.put(nums[Right_pointer], map.getOrDefault(nums[Right_pointer], 0) + 1);
            
            while(map.get(nums[Right_pointer])>k){
                    
                map.put(nums[Left_pointer], map.getOrDefault(nums[Left_pointer], 0) - 1);
                Left_pointer ++;
            }

            answer = Math.max( answer , Right_pointer - Left_pointer + 1);
        }
        return answer;
    }
}