class Solution {
    //模拟题，要考虑多个细节
    public int myAtoi(String s) {
        int index = 0;
        int res = 0;
        int op = 1;
        //去掉空格
        while(index < s.length()){
            if(s.charAt(index) == ' '){
                index ++;
            }else break;
        }
        //极端情况
        if(index >= s.length()) return res;
        //判断正负
        if(s.charAt(index) == '+' || s.charAt(index) == '-'){
            if(s.charAt(index) == '-') op = -1;
            index ++;
        }
        //处理数字
        while(index < s.length()){
            int num = s.charAt(index) - '0';
            //如果非数字
            if(num >= 10 || num < 0){
                break;
            }
            int temp = res;
            res = res * 10 + num;
            //判断是否超过最大值
            if(res / 10 != temp){
                if(op == 1){
                    return Integer.MAX_VALUE;
                }else return Integer.MIN_VALUE;
            }
            index ++;
        }
        //最后注意符号
        return res*op;

    }
}
