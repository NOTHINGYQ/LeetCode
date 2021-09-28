class Solution {
    //dp，在台阶问题的基础上加了权重
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        //如果长度为2
        if(cost.length == 2) return Math.min(cost[0],cost[1]);
        //初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        //递推
        for(int i = 2; i < cost.length; i ++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}