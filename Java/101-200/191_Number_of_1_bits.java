public class Solution {
    // you need to treat n as an unsigned value
    //方法1 直接将其与1做 & 运算，来计算1的个数
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count ++;
            }
            n >>>= 1;
        }
        return count;
    }
    //方法2 根据 n&(n - 1) 可以使n中最低位的1变为0的性质，看能有几个1
    public int hammingWeight(int n){
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count ++;
        }
        return count;
    }
}