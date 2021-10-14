class Solution {
    //dp或贪心法
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        int res = 1;
        int curDiff;
        int preDiff = 0;
        for(int i = 1; i < nums.length; i ++){
            curDiff = nums[i] - nums[i - 1];
            //注意此处curDiff不能等于0
            if((curDiff < 0 && preDiff >= 0) || (curDiff > 0 && preDiff <= 0)){
                res ++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}