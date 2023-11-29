/**
 * merge sort
 * average: O(nlogn)
 * best: O(nlogn)
 * worst: O(nlogn)
 * space: O(n)
 * sort type: Out-place占用额外内存
 * 稳定性：稳定
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = (left + right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while(i <= mid) tmp[k++] = arr[i++];
        while(j <= right) tmp[k++] = arr[j++];
        for(i = left; i <= right; i ++){
            arr[i] = tmp[i - left];
        }
    }
}
