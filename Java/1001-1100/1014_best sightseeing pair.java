class Solution {
    //dp，但要注意不能用dp[i][j],会内存溢出，所以用两个变量来交替进行
    public int maxScoreSightseeingPair(int[] values) {
        int dp = values[0] + 0;
        int ans = 0;
        for(int j = 1; j < values.length; j ++){
            ans = Math.max(ans, values[j] + dp - j);
            dp = Math.max(values[j] + j, dp);
        }
        return ans;
    }
}