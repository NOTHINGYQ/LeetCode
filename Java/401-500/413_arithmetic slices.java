class Solution {
    //dp，找递推式
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <= 2) return 0;
        //表示以nums[i]结尾的，且长度大于等于3的连续等差数列
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 2; i < nums.length; i ++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}