class Solution {
    //dp, 递增子序列问题，dp[i]表示以i个数字结尾的最长上升子序列的长度
    //从小到大计算dp[i]的值，在计算dp[i]之前，已经计算出了dp[0...i - 1]的值，则状态转移方程为
    //dp[i] = max(dp[j]) + 1, 0 <= j < i, num[j] < num[i]
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i ++){
            dp[i] = 1;
            for(int j = 0; j < i; j ++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]  + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}