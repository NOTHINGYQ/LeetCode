class Solution {
    //dp， dp[i][j]表示[i,j]内的最大回文串长度，且只有当0<= i <= j < n，才有dp[i][j] > 0, 否则dp[i][j] = 0
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp表示最大回文子序列的长度
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i --){
            //由于每一个长度为1的序列都是回文
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j ++){
                //当首尾两个字符相等时，则最大长度加2
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    //当不等时，则为前一个状态中的最大值
                }else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}