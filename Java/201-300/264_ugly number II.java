class Solution {
    //dp，定义dp[i]表示第i个丑数，定义三个指针p2,p3,p5表示下一个丑数是当前指针指向的丑数乘以对应的质因数，
    //令dp[i] = min(dp[p2] * 2, dp[p3] * 3, dp[p5]*5)，然后分别比较dp[i]和dp[p2]*2, dp[p3]*3, dp[p5]*5是否相等，等则+1
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];

        int p2 = 1, p3 = 1, p5 = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++){
            int n2 = dp[p2]* 2, n3 = dp[p3]*3, n5 = dp[p5]* 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            //这里不能用else if因为可能出现多个相等情况
            if(dp[i] == n2){
                p2++;
            }
            if(dp[i] == n3){
                p3 ++;
            }
            if(dp[i] == n5){
                p5 ++;
            }
        }
        return dp[n];

    }
}