class Solution {
    //dp hard, 注意插入和删除是可以等价的
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //如果有一个单词长度为0
        if(m * n == 0) return (m + n);

        //单词1的删除=单词2的插入
        int[][] dp = new int[m + 1][n + 1];
        //处理边界问题
        for(int i = 0; i <= m; i ++){
            //意义表示单词2为0时，在单词2中插入相应个数的单词1
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j ++){
            //意义为单词1为0时，在单词1中插入相应个数的单词2
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                //表示不等的时候，只需修改1个即可
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    dp[i - 1][j - 1] += 1;
                }
                //+1表示要插入1个来使得相等
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
            }
        }
        return dp[m][n];
    }
}