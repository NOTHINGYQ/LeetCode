class Solution {
    //dp, dp[i][j]表示以ij为右下角的只包含1的正方形边长从最大值
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //dp表示以(i,j)为右下角的只包含1的最大正方形的边长
        int[][] dp = new int[m][n];
        int res = 0;
        dp[0][0] = matrix[0][0] == '0' ? 0 : 1;
        res = Math.max(res, dp[0][0]);
        for(int i = 1; i < m; i ++){
            if(matrix[i][0] == '0') continue;
            else{
                dp[i][0] = 1;
                res = Math.max(res, dp[i][0]);
            } 
        }
        for(int j = 1; j < n; j ++){
            if(matrix[0][j] == '0') continue;
            else{
                dp[0][j] = 1;
                res = Math.max(dp[0][j], res);
            } 
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(matrix[i][j] == '0') continue;
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }
}