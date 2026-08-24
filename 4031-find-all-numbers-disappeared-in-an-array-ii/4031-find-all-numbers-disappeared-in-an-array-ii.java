class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
     int n = nums.length;
     Set<Integer> st = new HashSet<>();
     for(int i = 0; i < n; i++){
        st.add(nums[i]);
     }

     List<List<Integer>> ans = new ArrayList<>();
     for(int i = lower; i <= upper; i++){
        if(!st.contains(i)){
            if(ans.isEmpty()){
                ans.add(Arrays.asList(i,i));
                continue;
            }

            List<Integer> temp = ans.get(ans.size()-1);
            if(temp.get(1) + 1 == i){
                ans.remove(ans.size()-1);
                ans.add(Arrays.asList(temp.get(0), i));
            }else{
                ans.add(Arrays.asList(i,i));
            }
        }
     }

     return ans;


    }
}