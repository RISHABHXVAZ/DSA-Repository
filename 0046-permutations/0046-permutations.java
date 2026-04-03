class Solution {
    void func(List<Integer> temp, List<List<Integer>> ans){
        if(!ans.contains(temp)){
            ans.add(new ArrayList<>(temp));
        }else return;

        for(int i = 0; i < temp.size(); i++){
            for(int j = i+1; j < temp.size(); j++){
                int val = temp.get(i);
                temp.set(i, temp.get(j));
                temp.set(j, val);
                func(temp, ans);
                val = temp.get(i);
                temp.set(i, temp.get(j));
                temp.set(j, val);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) temp.add(nums[i]);
        func(temp, ans);
        return ans;
    }
}