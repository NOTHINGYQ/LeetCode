class Solution {
    //dp法
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        //dp表示字符串t中每个位置i处，字符j(即a-z所有字符)在i位置及之后位置中第一次出现的位置
        int[][] dp = new int[m + 1][26];
        for(int i = 0; i < 26; i ++){
            dp[m][i] = m;
        }
        //得到字符串t的所有字符位置信息
        for(int i = m - 1; i >= 0; i --){
            for(int j = 0; j < 26; j ++){
                if(t.charAt(i) == j + 'a'){
                    dp[i][j] = i;
                }else dp[i][j] = dp[i + 1][j];
            }
        }
        int index = 0;
        for(int i = 0; i < n; i ++){
            if(dp[index][s.charAt(i) - 'a'] == m){
                return false;
            }
            //找对应t中下一个字符位置
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    
    //双指针法
    public boolean isSubsequence(String s, String t){
        int a = 0;
        int b = 0;
        while(a < s.length() && b < t.length()){
            if(s.charAt(a) == t.charAt(b)){
                a ++;
                b ++;
            }else b ++;
        }
        return a == s.length();
    }
}