/**
 * bubble sort
 * average: O(n^2)
 * best: O(n)
 * worst: O(n^2)
 * space: O(1)
 * sort type: in-place只用常数内存
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr.length == 0) return;
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr.length - 1 - i; j ++){
                if(arr[j + 1] < arr[j]){
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

    }

}
