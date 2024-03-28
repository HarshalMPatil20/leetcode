class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int Left_pointer = 0;
        int Right_pointer = 0;
        int answer = 0;

        while( Right_pointer<nums.length && Left_pointer<nums.length ){
            
            map.put(nums[Right_pointer], map.getOrDefault(nums[Right_pointer], 0) + 1);
            
            while(map.get(nums[Right_pointer])>k){
                    
                map.put(nums[Left_pointer], map.getOrDefault(nums[Left_pointer], 0) - 1);
                Left_pointer ++;
            }

            answer = Math.max( answer , Right_pointer - Left_pointer + 1);
            Right_pointer ++;
        }
        return answer;
    }
}