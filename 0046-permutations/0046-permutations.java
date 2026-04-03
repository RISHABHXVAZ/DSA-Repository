class Solution {
    void func(int index, List<Integer> temp, Set<List<Integer>> st){
        if(index == temp.size()){
            st.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < temp.size(); i++){
            int val = temp.get(index);
            temp.set(index, temp.get(i));
            temp.set(i, val);
            func(index+1, temp, st);
            val = temp.get(index);
            temp.set(index, temp.get(i));
            temp.set(i, val);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
       Set<List<Integer>> st = new HashSet<>();
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) temp.add(nums[i]);
        func(0,temp, st);

        for(List<Integer> lst: st) ans.add(lst);
        return ans;
    }
}