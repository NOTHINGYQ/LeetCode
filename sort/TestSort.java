
public class TestSort {
    public static void main(String[] args){
        int[] arr = {2,4,1,5,68,2,4,1};
//        MergeSort.mergeSort(arr, 0, arr.length - 1);
//        BubbleSort.bubbleSort(arr);
//        SelectionSort.selectionSort(arr);
//        InsertionSort.insertionSort(arr);
        HeapSort.heapSort(arr);
        for(int a:arr)
            System.out.print(a + " ");
    }
}
