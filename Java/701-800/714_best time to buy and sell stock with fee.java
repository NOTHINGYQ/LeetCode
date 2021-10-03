class Solution {
    public int maxProfit(int[] prices, int fee) {
        //2个状态，0 表示持有股票，1表示不持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0]; //持有股票 
        dp[0][1] = 0; //不持有股票
        for(int i = 1; i < prices.length; i ++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}