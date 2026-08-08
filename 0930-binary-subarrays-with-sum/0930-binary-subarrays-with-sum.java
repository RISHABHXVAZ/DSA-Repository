class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int[] pref = new int[n];
        pref[0] = nums[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + nums[i];
        }
        int count = 0;
        for(int r = 0; r < n; r++){
            int t = pref[r] - goal;
            if(mpp.containsKey(t)){
                count += mpp.get(t);
            }

            mpp.put(pref[r], mpp.getOrDefault(pref[r], 0) + 1);
        }

        return count;
    }
}