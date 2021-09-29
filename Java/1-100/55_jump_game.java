class Solution {
    //方法1
    //贪心算法，设定一个cover变量用于表示可覆盖到的最远位置，
    // 向后遍历，直到能到达最后一个值或者到达最大覆盖范围为止
    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1) return true;
        for(int i = 0; i <= cover; i ++){
            cover = Math.max(cover, i + nums[i]);
            if(cover >= nums.length -1) return true;
        }
        return false;
    }

    //方法2
    //dp，递推式dp[i] = Math.max(dp[i - 1], i + nums[i]);
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length <= 1) return true;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(dp[i - 1] < i ) return false;
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }
}