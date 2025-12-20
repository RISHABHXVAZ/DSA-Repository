class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0) + 1);
        }
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(mpp.containsKey(nums[i]) && mpp.get(nums[i]) > 1){
                mpp.put(nums[i], mpp.get(nums[i]) - 1);
                idx = i;
            }
        }
        if(idx == -1) return 0;
        int cnt = idx+1;
        if(cnt <= 3) return 1;
        else{
            if(cnt % 3 == 0) return cnt/3;
            else return cnt/3 + 1;
        }

    }
}