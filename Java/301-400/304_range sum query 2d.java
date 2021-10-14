class NumMatrix {
    //dp,同利用二维前缀和，注意dp表示的是(0,0) -(i - 1, j - 1)的总和，这是为了避免处理第0行和第0列的特殊情况
    int[][] matrix;
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = matrix;
        dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //注意有一行的差
        int sum = dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        return sum;
    }
}