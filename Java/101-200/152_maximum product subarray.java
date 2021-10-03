class Solution {
    //dp,基于最大子序和问题，由于乘法要考虑正负
    public int maxProduct(int[] nums) {
        //用于存储当前下标处的乘积最大值
        int[] dpmax = new int[nums.length];
        //用于存储当前下标处的乘积最小值
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i ++){
            dpmax[i] = Math.max(Math.max(dpmax[i - 1] * nums[i], dpmin[i - 1] * nums[i]), nums[i]);
            dpmin[i] = Math.min(Math.min(dpmax[i - 1] * nums[i], dpmin[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, dpmax[i]);
        }
        return res;
    }
}