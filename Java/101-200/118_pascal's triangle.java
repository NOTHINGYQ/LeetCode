class Solution {
    //dp easy, 找规律即可
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j ++){
                if(j == 0 || j == i) list.add(1);
                if(j > 0 && j < i){
                    List<Integer> tmp = res.get(i - 1);
                    list.add(tmp.get(j - 1) + tmp.get(j));
                }
            }
            res.add(new ArrayList(list));
        }
        return res;
    }
}