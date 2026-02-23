class Solution {
    public int function(int i, int[] nums, int[] dp) {

        if (i < 0)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = Math.max(function((i - 2), nums, dp) + nums[i], function((i - 1), nums, dp));
    }

    public int rob(int[] nums) {

        int [] dp = new int[nums.length];

        Arrays.fill(dp,-1);

        return function(nums.length-1,nums,dp);
    }
}