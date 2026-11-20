class Solution {
    int func(int i, int target, int[] nums){
        int n = nums.length;
        if(i == n){
            if(target == 0) return 1;
            return 0;
        }
        int plus = func(i+1, target-nums[i], nums);
        int minus = func(i+1, target+nums[i], nums);
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int[][] dp = new int[n][];
        return func(0, target, nums);
    }
}