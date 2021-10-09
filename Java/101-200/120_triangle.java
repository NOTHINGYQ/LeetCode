class Solution {
    //dp，与杨辉三角类似，本行的和由上一行的值决定，找递推，注意边界
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i ++){
            for(int j = 0; j <= i; j ++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            res = Math.min(res, dp[n -1][i]);
        }
        return res;
    }
}