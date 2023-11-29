import java.util.Random;

public class QuickSelect {
    public static void main(String[] args){
        int[] nums ={3,2,1,5,6,4};
        int n = nums.length;
        int k = 2;
        int ans = findKthLargest(nums, k);
        System.out.println(ans);
    }
    public static int findKthLargest(int[] nums, int k){
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }
    public static int quickSelect(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];
        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left);
        pivot_index = partition(nums, left, right, pivot_index);
        if(k == pivot_index) return nums[k];
        else if(k < pivot_index) return quickSelect(nums, left, pivot_index - 1, k);
        else return quickSelect(nums, pivot_index + 1, right, k);
    }
    public static int partition(int[] nums, int left, int right, int index){
        int pivot = nums[index];
        swap(nums, index, right);
        int j = left;
        for(int i = left; i <= right; i ++){
            if(nums[i] < pivot){
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, right);
        return j;
    }
    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
