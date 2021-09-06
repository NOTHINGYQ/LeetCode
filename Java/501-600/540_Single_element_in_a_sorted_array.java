class Solution {
    //位运算法
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }

    //二分法，注意左右边界的细节
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            boolean even = (high - mid) % 2 == 0;
            if(nums[mid] == nums[mid + 1]){
                if(even){
                    low = mid + 2;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] == nums[mid - 1]){
                if(even){
                    high = mid - 2;
                }else{
                    low = mid + 1;
                }
            }else return nums[mid];
        }
        return nums[low];
    }
}