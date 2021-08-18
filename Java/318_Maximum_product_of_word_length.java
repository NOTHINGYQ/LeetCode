class Solution {
    //位操作+预计算， 先把各个string的长度和位掩码存好，然后暴力搜索最大值
    public int maxProduct(String[] words) {
        int bitMask = 0;
        int[] mask = new int[words.length];
        int[] length = new int[words.length];
        for(int i = 0; i < words.length; i ++){
            bitMask = 0;
            length[i] = words[i].length();
            for(char ch:words[i].toCharArray()){
                bitMask |= 1 << bitNumber(ch);
            }
            mask[i] = bitMask;
        }
        int res = 0;
        for(int i = 0; i < words.length; i ++){
            for(int j = i + 1; j < words.length; j ++){
                if((mask[i] & mask[j]) == 0){
                    res = Math.max(res, length[i] * length[j]);
                }
            }
        }
        return res;
    }
    public int bitNumber(char ch){
        return ch - 'a';
    }
}