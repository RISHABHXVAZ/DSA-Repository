class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < n; i++){
            st.add(nums[i]);
        }

        int a = 1;
        while(st.contains(a*k)){
            a++;
        }

        return a*k;
    }
}