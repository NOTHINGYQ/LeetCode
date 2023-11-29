/**
 * heap sort
 * average: O(nlogn)
 * best: O(nlogn)
 * worst: O(nlogn)
 * space: O(1)
 * sort type: in-place只用常数内存
 * 稳定性：不稳定
 */
public class HeapSort {
    static int len;
    public static void heapSort(int[] arr){
        len = arr.length;
        if(arr.length < 1)return;
        buildMaxHeap(arr);
        while(len > 0){
            swap(arr, 0, len - 1);
            len --;
            adjustHeap(arr, 0);
        }
    }
    public static void buildMaxHeap(int[] arr){
        //从最后一个非叶子节点开始向上构造最大堆
        for(int i = (len/2 - 1); i >= 0 ; i --){
            adjustHeap(arr, i);
        }
    }
    public static void adjustHeap(int[] arr, int i){
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if(i*2 < len && arr[i*2] > arr[maxIndex]){
            maxIndex = i*2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if(i*2 + 1 < len && arr[i*2 + 1] > arr[maxIndex]){
            maxIndex = i*2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if(maxIndex != i){
            swap(arr, maxIndex, i);
            adjustHeap(arr, maxIndex);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
