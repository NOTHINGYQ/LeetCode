class Solution {
    //双指针法
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(Math.abs(temp - target) < min){
                    min = Math.abs(temp - target);
                    result = temp;
                }
                if(temp == target) return result;
                else if(temp > target){
                    right --;
                }else{
                    left ++;
                }

            }
        }
        return result;
    }
}