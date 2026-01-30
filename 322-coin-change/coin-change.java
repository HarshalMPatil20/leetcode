class Solution {
    public int fun(int i, int amt,int[][] dp,int[] coins){

    if(coins.length == i || amt<0) return 10000000;
    if(amt==0) return 0; 

    if(dp[i][amt]!=-1){return dp[i][amt];}

    int take = fun(i,amt-coins[i],dp,coins)+1;
    int nontake = fun(i+1,amt,dp,coins);

    // System.out.println(i+ " " +amt);
    // System.out.println(Math.min(take,nontake));
    return dp[i][amt] = Math.min(take,nontake);

    }


    public int coinChange(int[] coins, int amount) {

        int [][] dp = new int [coins.length+1][amount+1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans=fun(0,amount,dp,coins);

        return ans==10000000?-1:ans;   
    }
}