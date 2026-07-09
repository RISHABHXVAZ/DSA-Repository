class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[j] > nums[i]) ans = Math.max(nums[j]-nums[i], ans);
            }
        }

        return ans == 0 ? -1: ans;
    }
}