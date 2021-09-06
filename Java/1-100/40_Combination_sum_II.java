class Solution {
    //回溯，注意数组中数字可重复，但数字在组合中只能用一次
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, used);
        return res;
    }
    private void backtracking(int[] candidates, int target, int sum, int index, boolean[] used){
        if(sum == target){
            res.add(new ArrayList(list));
            return;
        }
        if(sum > target) return;
        for(int i = index; i < candidates.length; i ++){
            if(i > index && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            list.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, sum, i + 1, used);
            used[i] = false;
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}