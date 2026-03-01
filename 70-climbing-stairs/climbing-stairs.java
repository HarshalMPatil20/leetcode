class Solution {
    public int function(int i, int[] dp){
        if(dp[i] != 0) return dp[i];

        if(i == 0 || i == 1) return dp[i] = 1;

        return dp[i] = function(i-1,dp)+function(i-2,dp);
    }
    public int climbStairs(int n) {

        int[] dp  = new int[n+1];

        return function(n , dp);
        
    }
}