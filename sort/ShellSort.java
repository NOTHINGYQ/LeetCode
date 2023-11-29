/**
 * shell sort
 * average: O(nlogn)
 * best: O(nlog^2n)
 * worst: O(nlog^2n)
 * space: O(1)
 * sort type: in-place只用常数内存
 * 稳定性：不稳定
 */
public class ShellSort {
    public static void shellSort(int[] arr){
        int len = arr.length;
        int tmp, gap = len/2;
        while(gap > 0){
            for(int i = gap; i < len; i ++){
                tmp = arr[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && arr[preIndex] > tmp){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = tmp;
            }
            gap/=2;
        }
    }
    public void shel(int[] arr){
        int n = arr.length;
        int tmp, gap = n/2;
        while(gap > 0){
            for(int i = gap; i < n; i ++){
                tmp = arr[i];
                int preI = i - gap;
                while(preI >= 0 && arr[preI] > tmp){
                    arr[preI + gap]= arr[preI];
                    preI -= gap;
                }
                arr[preI + gap]= tmp;
            }
            gap/=2;
        }
    }
}
