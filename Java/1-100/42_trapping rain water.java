class Solution {
    //双指针法
    // 使用height[left]和heigth[right]的值更新leftmax 和 rightmax
    // 如果有height[left] < height[right],则必有Leftmax< rightmax,下标left处能接的雨量等于leftmax -height[left]
    // 如果有heigth[left] >= heigth[right],则必有leftmax >= rightmax,下标right 处能接的雨量等于rightmax - height[right];
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftmax = height[0];
        int rightmax = height[right];
        int count = 0;
        while(left <= right){
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            if(height[left] < height[right]){
                count += leftmax - height[left];
                left ++;
            }else{
                count += rightmax - height[right];
                right --;
            }
        }
        return count;
    }

}


class Solution {
    //dp法
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        //使用leftmax[i]记录i及其左边位置的最大值
        int[] leftmax = new int[height.length];
        //使用rightmax[i]记录i及其右边位置的最大值
        int[] rightmax = new int[height.length];

        //先从左向右扫描得到leftmax数组
        leftmax[0] = height[0];
        for(int i = 1; i < height.length; i ++){
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        //从右向左扫描得到rightmax数组
        rightmax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i --){
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        //计算最终雨水量，利用在i处的雨水为 min(leftmax[i], rightmax[i]) - height[i];
        int count = 0;
        for(int i = 0; i < height.length; i ++){
            count += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        return count;
    }
}