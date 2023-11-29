/**
 * quick sort
 * average: O(nlogn)
 * best: O(nlogn)
 * worst: O(n^2)
 * space: O(logn)
 * sort type: in-place只用常数内存
 * 稳定性：不稳定
 */
public class QuickSort {
    public static void main(String[] args){
        int[] nums ={3,2,1,5,6,4};
        int n = nums.length;
        int k = 2;
        quickSort(nums, 0, n - 1);
        for(int i = 0; i < n; i ++){
            System.out.println(nums[i]);
        }
    }
    public static void quickSort(int[] arr,int left, int right){
        if(arr.length < 1 || left < 0 || right >= arr.length || left > right) return;
        int smallIndex = partition(arr, left,right);
        if(smallIndex > left){
            quickSort(arr,left, smallIndex - 1);
        }
        if(smallIndex < right){
            quickSort(arr, smallIndex + 1, right);
        }
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = (int)(left + Math.random()*(right - left + 1));
        int smallIndex = left - 1;
        swap(arr, pivot, right);
        for(int i = left; i <= right; i ++){
            if(arr[i] <= arr[right]){
                smallIndex++;
                if(i > smallIndex)
                    swap(arr,i, smallIndex);
            }
        }
        return smallIndex;
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
