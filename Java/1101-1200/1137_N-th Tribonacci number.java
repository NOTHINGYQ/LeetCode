class Solution {
    //动态规划，定义数组找到递归式，直接循环即可
    public int tribonacci(int n) {
        int [] dp = new int[38];
         dp[2] = dp[1] = 1;
         if(n <= 2) return dp[n];
         for(int i = 3; i <= n; i ++){
             dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
         }
         return dp[n];
    }
}