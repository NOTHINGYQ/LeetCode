class Solution {
    //dp，找规律，得到递推式，
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                dp[i] += dp[j - 1]* dp[i - j];
            }
        }
        return dp[n];
    }
}