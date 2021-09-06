class Solution {
    //当反转数字后，即使溢出，也可判断是否回文
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = x;
        int new_x = 0;
        while(y != 0){
            new_x = new_x * 10 + y % 10;
            y /= 10;
        }
        return new_x == x ? true : false;
    }
}