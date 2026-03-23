class Solution {
    void func(List<Integer> temp, int i, int sum, int[] candidates, int target, List<List<Integer>> ans){
        if(sum > target) return;
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] > target-sum) break;

            temp.add(candidates[j]);
            func(temp,j+1, sum + candidates[j], candidates, target, ans);
            temp.remove(temp.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        func(new ArrayList<>(), 0, 0, candidates, target, ans);
        return ans;
    }
}