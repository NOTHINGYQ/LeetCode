class Solution {
    //在不用除法的情况下，左右各扫描一次，最后两个数组相乘即可得
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        int[] out = new int[nums.length];
        for(int i = 1; i < nums.length; i ++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        for(int i = nums.length - 2; i >= 0; i --){
            right[i] = nums[i + 1] * right[i + 1];
        }
        for(int i = 0; i < nums.length; i ++){
            out[i] = left[i] * right[i];
        }
        return out;
    }
}
