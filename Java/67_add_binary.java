class Solution {
    //位运算题，注意细节点，
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        //进位项
        int c = 0;
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0){
            c += i >= 0 ? a.charAt(i) - '0': 0;
            c += j >= 0 ? b.charAt(j) - '0': 0;
            i --;
            j --;
            res.append(c % 2);
            c >>>= 1;
        }
        res.reverse();
        //防止进位项仍有值的情况
        return c > 0 ? "1" + res.toString() : res.toString();

    }
}