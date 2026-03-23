class Solution {
    void func(List<Integer> temp, int sum, int i, int[] candidates, int target, List<List<Integer>> ans){
        if(sum > target) return;
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i == candidates.length) return;
        temp.add(candidates[i]);
        func(temp, sum + candidates[i], i, candidates, target, ans);
        temp.remove(temp.size()-1);
       func(temp, sum , i+1, candidates, target, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        func(new ArrayList<>(), 0, 0, candidates,target,ans);
        return ans;
    }
}