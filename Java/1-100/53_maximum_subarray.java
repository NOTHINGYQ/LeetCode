class Solution {
    //dp，关键找递推式
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i ++){
            //得到当前下标处的最大值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //每次更新总结果
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}