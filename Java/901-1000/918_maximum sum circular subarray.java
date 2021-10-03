class Solution {
    //dp，基于最大子序和问题，环形子数组的最大和可以拆成两部分来解，首先求出数组的最大子序和，然后再
    //求出数组的最小子序和，用数组总和 - 最小子序和 = 环形状态下的最大子序和，然后再和非环形状态下的
    //最大子序和求max即可最终值
    public int maxSubarraySumCircular(int[] nums) {
        int[] dpmax = new int[nums.length];
        int max = nums[0];
        dpmax[0] = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i ++){
            dpmax[i] = Math.max(dpmax[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dpmax[i]);
            sum += nums[i];
        }
        
        int[] dpmin = new int[nums.length];
        int min = nums[0];
        dpmin[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            dpmin[i] = Math.min(dpmin[i - 1] + nums[i], nums[i]);
            min = Math.min(min, dpmin[i]);
        }
        //排除 -1，-2，-3 这种sum与min相等的情况
        return Math.max(max, sum - min == 0 ? max : sum - min);
    }
}