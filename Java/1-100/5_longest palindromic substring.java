class Solution {
    //dp，利用暴力优化法
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxlen = 0;
        String res = "";
        //遍历所有的长度，注意当i > j时无意义
        for(int  len = 1; len <= length; len ++){
            for(int start = 0; start < length; start ++){
                int end = start + len - 1;
                if(end >= length) break;
                //要单独判断len = 1和len =2 的情况
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);

                //更新最大长度
                if(dp[start][end] && len > maxlen){
                    maxlen = len;
                    res = s.substring(start, end + 1);
                }
            }
        }
        return res;
    }
}