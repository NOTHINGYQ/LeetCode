/**
 * counting sort
 * average: O(n + k)
 * best: O(n + k)
 * worst: O(n + k)
 * space: O(k)
 * sort type: out-place
 * 稳定性：稳定
 */
public class CountingSort {
    public static void countingSort(int[] arr){
        if(arr.length == 0) return;
        int bias , min = arr[0], max = arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        for(int i = 0; i < arr.length; i ++){
            bucket[arr[i] + bias] ++;
        }
        int index = 0, i = 0;
        while(index < arr.length){
            if(bucket[i] != 0){
                arr[index] = i - bias;
                bucket[i]--;
                index++;
            }else i++;
        }

    }
}
