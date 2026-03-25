class Solution {
    void func(List<Integer> temp, int sum, int i, int n, int k, List<List<Integer>> ans){
        if(temp.size() == k && sum == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size() > k || sum > n) return;

        for(int j = i; j < 10; j++){
            temp.add(j);
            func(temp, sum+j, j+1, n, k, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        func(new ArrayList<>(), 0, 1, n, k, ans);
        return ans;
    }
}