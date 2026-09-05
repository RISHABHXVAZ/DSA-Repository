class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + nums[i];
        }
        mpp.put(0, 1);
        int ans = 0;
        //subarray is nums[l+1].......nums[r+1]
        for(int r = 0; r < n; r++){
            int target = (pref[r] % k + k) % k;
            if(mpp.containsKey(target)){
                ans += mpp.get(target);
            }

            mpp.put(target, mpp.getOrDefault(target,0)+1);
        }

        return ans;
    }
}