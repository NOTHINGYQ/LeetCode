class Solution {
    //动态规划，完全背包问题
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i ++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < coins.length; i ++){
            for(int j = coins[i]; j <= amount; j ++){
                if(dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}