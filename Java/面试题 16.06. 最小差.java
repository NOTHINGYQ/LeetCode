class Solution {
    //排序 + 双指针；注意做差的时候要考虑到越界（int最大值）
    public int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);
        long ans = Math.abs((long)a[0] - b[0]);
        for(int i = 0, j = 0; i < a.length && j < b.length;){
            long diff = Math.abs((long)a[i] - b[j]);
            if(diff < ans) ans = diff;
            if(a[i] <= b[j]) i ++;
            else j ++;
        }
        return (int)ans;
    }
}
