class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        for(int i = 0; i < right + 1; i ++){
            if(nums[i] == 0){
                int temp = nums[left];
                nums[left ++] = nums[i];
                nums[i] = temp;
            }else if(nums[i] == 2){
                int temp = nums[right];
                nums[right --] = nums[i];
                nums[i] = temp;
                i --;
            }
        }

    }
}
