class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxind = 0;
        for(int i = 0; i < n; i++){
            int steps = i + nums[i];
            if(i > maxind) return false;
            if(steps >= n-1) return true;
            if(steps > maxind) maxind = steps;
        }
        return false;
    }
}