/**
 * selectoin sort
 * average: O(n^2)
 * best: O(n^2)
 * worst: O(n^2)
 * space: O(1)
 * sort type: in-place只用常数内存
 * 稳定性：不稳定
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr.length == 0) return;
        for(int i = 0; i < arr.length; i ++){
            int minIndex = i;
            for(int j = i; j < arr.length; j ++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

}
