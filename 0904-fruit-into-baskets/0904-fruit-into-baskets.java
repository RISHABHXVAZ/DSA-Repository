class Solution {
    public int totalFruit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxlen = 0;
        int i = 0;
        for(int j = 0; j < n; j++){
            mpp.put(nums[j], mpp.getOrDefault(nums[j],0)+1);

            while(i < n && mpp.size() > 2){
                mpp.put(nums[i], mpp.get(nums[i])-1);
                if(mpp.get(nums[i]) == 0) mpp.remove(nums[i]);
                i++;
            }

            maxlen = Math.max(maxlen, j-i+1);
        }

        return maxlen;
    }
}