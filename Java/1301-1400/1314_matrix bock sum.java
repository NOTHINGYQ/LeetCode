class Solution {
	//dp,使用了二维前缀和的知识。
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        //dp[i][j]表示以（0，0）为左上角，（i - 1，j - 1）为右下角的矩阵的和
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                //大框的x，y
                int ux = Math.min(i + k + 1, m);
                int uy = Math.min(j + k + 1, n);
                //小框的x,y
                int dx = Math.max(i - k, 0);
                int dy = Math.max(j - k, 0);
                ans[i][j] = dp[ux][uy] - dp[dx][uy] - dp[ux][dy] + dp[dx][dy];
            }
        }
        return ans;
    }
}