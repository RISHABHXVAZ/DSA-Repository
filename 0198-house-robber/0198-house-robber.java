class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
    
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int p1 = nums[0];
        int p2 = Math.max(nums[0], nums[1]);
        int curr;
        for(int i = 2; i < n; i++){
            curr = Math.max(p1 + nums[i], p2);
            p1 = p2;
            p2 = curr;
        }
        return p2;
    }
}