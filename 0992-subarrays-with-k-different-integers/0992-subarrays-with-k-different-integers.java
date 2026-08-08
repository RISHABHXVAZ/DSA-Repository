class Solution {
    int func(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();

        int i = 0;
        for(int j = 0; j < n; j++){
            mpp.put(nums[j], mpp.getOrDefault(nums[j], 0)+1);

            while(i <= j && mpp.size() > k){
                mpp.put(nums[i], mpp.get(nums[i])-1);
                if(mpp.get(nums[i]) == 0) mpp.remove(nums[i]);
                i++;
            }

           count += (j-i+1);
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums, k) - func(nums, k-1);
    }
}