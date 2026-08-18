class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i <= n-k; i++){
            Set<Integer> st = new HashSet<>();
            for(int j = i; j < i+k && j < n; j++){
                if(st.contains(nums[j])) continue;
                st.add(nums[j]);
                mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
            }
        }

        int ans = -1;
        for(int num : mpp.keySet()){
            if(mpp.get(num) == 1 && num > ans) ans = num;
        }

        return ans;
    }
}