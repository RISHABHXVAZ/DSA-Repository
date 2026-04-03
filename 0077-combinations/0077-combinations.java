class Solution {
    void func(int i, List<Integer> temp,int n, int k, List<List<Integer>> ans){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i > n) return;
        for(int j = i; j <= n; j++){
            temp.add(j);
            func(j+1, temp, n, k, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        func(1, new ArrayList<>(),n, k, ans);
        return ans;
    }
}