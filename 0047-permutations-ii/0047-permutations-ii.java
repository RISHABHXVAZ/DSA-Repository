class Solution {
    void func(int index, List<Integer> temp, List<List<Integer>> ans){
        if(index == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        Set<Integer> used = new HashSet<>();
        for(int i = index; i < temp.size(); i++){
            if(used.contains(temp.get(i))) continue;
           
            used.add(temp.get(i));
            int val = temp.get(index);
            temp.set(index, temp.get(i));
            temp.set(i, val);
            func(index+1, temp, ans);
            val = temp.get(index);
            temp.set(index, temp.get(i));
            temp.set(i, val);

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) temp.add(nums[i]);

        func(0, temp, ans);
        return ans;
    }
}