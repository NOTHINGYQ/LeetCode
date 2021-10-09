class Solution {
    //dp，注意类似台阶问题，字母可以分为一个字母编码或者两个编码，则dp[i]会和dp[i - 1]和dp[i - 2]有关
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s.length() <= 2 && s.charAt(0) == '0') return 0;
        dp[0] = 1;

        for(int i = 1; i <= s.length(); i ++){
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(i - 2 >= 0 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}