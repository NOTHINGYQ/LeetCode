class Solution {
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
}