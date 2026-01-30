class Solution {
    public int fun(int i, int n, int[] dp) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        if (dp[i] != -1)
            return dp[i];

        return dp[i] = fun(i + 1, n, dp) + fun(i + 2, n, dp);
    }

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return fun(0, n, dp);

    }
}