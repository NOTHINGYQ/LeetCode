class Solution {
	//动态规划，通过a b参数互换来实现记忆化递归
    public int fib(int n) {
        int a = 0;
        int b = 0;
        int sum = 1;
        for(int i = 1; i <= n; i ++){
            a = b;
            b = sum;
            sum = a + b;
        }
        return b;
    }
}