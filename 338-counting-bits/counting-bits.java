class Solution {

    public int function(int i, int[] dp){
        if(i == 0 || i == 1) return dp[i] = i;
        if ((i & (i - 1)) == 0) return dp[i] = 1;

        if(dp[i] != -1) return dp[i];

        return dp[i] = 1+function(i-Integer.highestOneBit(i),dp);
    }
    public int[] countBits(int n) {

        int[] dp = new int[n+1];

        Arrays.fill(dp,-1);

        for(int i = n; i>=0; i--){
            function(i,dp);
        }

        return dp;
        
    }
}