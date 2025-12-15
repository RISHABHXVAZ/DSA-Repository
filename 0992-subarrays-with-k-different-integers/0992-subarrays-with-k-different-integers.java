class Solution {
    static int func(int[] nums, int k){
        if(k < 0) return 0;
        int n = nums.length;
        int i = 0, j = 0;
        int cnt = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while(j < n){
            mpp.put(nums[j], mpp.getOrDefault(nums[j],0) + 1);
            while(mpp.size() > k){
                mpp.put(nums[i], mpp.get(nums[i]) - 1);
                if(mpp.get(nums[i]) == 0) mpp.remove(nums[i]);
                i++;
            }
            cnt += (j-i+1);
            j++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k-1);
    }
}