class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //转换为long型防止溢出
        long numeratorLong = (long)numerator;
        long denominatorLong = (long)denominator;
        //可以整除
        if(numeratorLong % denominatorLong == 0) return String.valueOf(numeratorLong / denominatorLong);
        
        //判断正负
        StringBuilder res = new StringBuilder();
        if(numeratorLong < 0 ^ denominatorLong < 0){
            res.append("-");
        }
        //整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        res.append(numeratorLong / denominatorLong);
        res.append(".");

        //小数部分
        long remainder = numeratorLong % denominatorLong;
        //使用一个新的tmp是为了防止出现在整数前面加“（ ”的情况
        StringBuilder tmp = new StringBuilder();
        Map<Long, Integer> remain = new HashMap<>();
        int index = 0;
        while(remainder != 0 && !remain.containsKey(remainder)){
            remain.put(remainder, index);
            remainder *= 10;
            tmp.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index ++;
        }
        //如果有循环节，则放入括号
        if(remain.containsKey(remainder)){
            tmp.insert(remain.get(remainder), "(");
            tmp.append(")");
        }
        res.append(tmp);
        return res.toString();
    }
}