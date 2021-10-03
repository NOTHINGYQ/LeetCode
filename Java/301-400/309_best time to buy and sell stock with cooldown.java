class Solution {
    public int maxProfit(int[] prices) {
        //dp，3个状态
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0]; //表示持有股票
        dp[0][1] = 0; //表示不持有，冷冻期不能买
        dp[0][2] = 0; //表示不持有，可以买
        for(int i = 1; i < prices.length; i ++){
            //当前状态是由上一个状态决定的，紧跟上一个状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] -prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}