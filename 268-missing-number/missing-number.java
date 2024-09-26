class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = nums[0];
        int xor2 = 0^1;

        for(int i=1; i<nums.length; i++ ){
            xor1 ^= nums[i];
            xor2 ^= i+1;
        }

        return xor1 ^ xor2;
    }
}