class Solution {
    //利用位运算
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for(int i = 7; i >= 0; i --){
            //由于16进制占4位，所以每四位算一个值，得到一个16进制值
            int val = (num >> (4 * i)) & 0xf;
            //如果num>0，在遍历时，在第一位不是0的处开始拼接16进制值，所以val>0是为了保证不出现前导0，同时res.length()>0，是为了保证在中间位为0的值不会被落下
            if(res.length() > 0 || val > 0){
                char temp = val < 10 ? (char)('0' + val) : (char)('a' + val - 10);
                res.append(temp);
            }
        }
        return res.toString();
    }
}