class Solution {
    public int maxProfit(int[] prices) {
        //2个状态，0表示持有股票， 1 表示不持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i ++){
            //注意本题由于可以多次买卖，故此处为 dp[i - 1][1] - prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}