class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] money = new int[n];
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
        }
        return money[n-1];
    }
}