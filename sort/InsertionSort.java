/**
 * insertion sort
 * average: O(n^2)
 * best: O(n)
 * worst: O(n^2)
 * space: O(1)
 * sort type: in-place只用常数内存
 * 稳定性：稳定
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr.length == 0) return;
        int current;
        for(int i = 0; i < arr.length - 1; i ++){
            current = arr[i + 1];
            int preIndex = i;
            while(preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

}
