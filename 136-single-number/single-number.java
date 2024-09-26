class Solution {
    public int singleNumber(int[] nums) {
        int missing_number=nums[0];

        for(int i=1;i<nums.length;i++){
            missing_number ^= nums[i];
        }

        return missing_number;
    }
}