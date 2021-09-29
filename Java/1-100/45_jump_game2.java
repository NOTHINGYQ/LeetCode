class Solution {
    //利用贪心
    public int jump(int[] nums) {
        //表示最远可以达到的下标
        int maxReach = 0;
        //表示结果步数
        int res = 0;
        //表示上一个最远可达的下标
        int end = 0;
        //i<nums.length-1是因为在到达nums边界时不需要再下一步了
        for(int i = 0; i < nums.length - 1; i ++){
            //不断更新可以最远到达的下标
            maxReach = Math.max(maxReach, i + nums[i]);
            //如果当前下标与上次所选择的最远步数到达的下标相等时，就步数+1，且更新新的步数将达到的边界下标
            if(end == i){
                end = maxReach;
                res ++;
            }
        }
        return res;
    }
}