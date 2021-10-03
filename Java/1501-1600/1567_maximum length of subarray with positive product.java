class Solution {
    //dp, 分类讨论，分成3中情况
    public int getMaxLen(int[] nums) {
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        int res = 0;
        if(nums[0] > 0){
            positive[0] = 1;
            res = 1;
        }else if(nums[0] < 0) negative[0] = 1;
        //由于乘积正负相乘变号，所以会交叉取值
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] > 0){
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            }else if(nums[i] < 0){
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            }else{
                positive[i] = negative[i] = 0;
            }
            res = Math.max(positive[i], res);
        }
        return res;
    }
}