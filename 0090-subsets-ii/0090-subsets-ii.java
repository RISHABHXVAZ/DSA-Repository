class Solution {
    void func(List<Integer> temp, int i, int[] nums, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        if(i == nums.length) return;

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]) continue;

            temp.add(nums[j]);
            func(temp, j+1, nums, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        func(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
}