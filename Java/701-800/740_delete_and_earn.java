class Solution {
    //dp,转化为打家劫舍问题
    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        //寻找nums中的最大值
        for(int num: nums){
            maxValue = Math.max(maxValue, num);
        }
        int[] sum = new int[maxValue + 1];
        //求出每个相同值所表示的总和
        for(int num: nums){
            sum[num] += num;
        }
        return rob(sum);
    }
    public int rob(int[] sum){
        if(sum.length == 1) return sum[0];
        int first = sum[0];
        int second = Math.max(sum[0], sum[1]);
        for(int i = 2; i < sum.length; i ++){
            int temp = second;
            second = Math.max(first + sum[i], temp);
            first = temp;
        }
        return second;
    }
}