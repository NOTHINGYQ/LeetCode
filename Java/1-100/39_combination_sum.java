class Solution{
    /*
    回溯问题，同时是排列组合类问题
    本题直接套通用框架即可，但需要注意给定的数组为无重复元素的数组，这也就意味着不需要判断是否使用过等步骤；
    其次要注意数组中的数字可以无限制选取，同时要防止重复，所以在for循环中每次进入一个新的递归时需要传入的是当前的下标值，
    否则得到的重复结果。
    **/
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }
    private void backtracking(int[] candidates, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList(list));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < candidates.length; i ++){
            sum += candidates[i];
            list.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}