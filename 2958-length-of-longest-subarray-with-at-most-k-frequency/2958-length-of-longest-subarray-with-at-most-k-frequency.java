class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        int i = 0;
        int maxlen = 0;
        for(int j = 0; j < n; j++){
            mpp.put(nums[j], mpp.getOrDefault(nums[j],0)+1);

            while(mpp.get(nums[j]) > k){
                mpp.put(nums[i], mpp.get(nums[i])-1);
                if(mpp.get(nums[i]) == 0) mpp.remove(nums[i]);
                i++;
            }

            maxlen = Math.max(maxlen, j-i+1);
        }

        return maxlen;
    }
}