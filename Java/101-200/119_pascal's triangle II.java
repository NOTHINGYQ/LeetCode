class Solution {
    //dp easy，找规律即可
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i ++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j ++){
                if(j == 0 || j == i) list.add(1);
                if(j > 0 && j < i){
                    List<Integer> tmp = res.get(i - 1);
                    list.add(tmp.get(j - 1) + tmp.get(j));
                }
            }
            res.add(list);
        }
        return res.get(rowIndex);
    }
}