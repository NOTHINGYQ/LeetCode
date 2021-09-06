class Solution {
    //方法1 使用位运算的方式，利用 n ^ n = 0这个公式可求出缺失的值
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i ++){
            res ^= i + 1;
            res ^= nums[i];
        }
        return res;
    }
    //方法2 可以利用先排序后直接返回的方式
    public int missingNumber(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
}