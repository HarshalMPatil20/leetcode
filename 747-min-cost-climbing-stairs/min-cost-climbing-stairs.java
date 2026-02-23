class Solution {
    public int function(int i, int[] cost, int[] dp){

        if(i<=1) return 0;

        if(dp[i] != -1) return dp[i];
                
        
        return dp[i] = Math.min(function(i-1,cost,dp) + cost[i-1], function(i-2,cost,dp) + cost[i-2]);
        

    }
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];

        Arrays.fill(dp,-1);

        return function(cost.length,cost,dp);
        
    }
}