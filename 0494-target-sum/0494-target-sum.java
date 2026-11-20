class Solution {
    int func(int i, int target, int[] nums, int[][] dp){
        int n = nums.length;
        if(target < 0) return 0;
        if(i == n) return target == 0 ? 1 : 0;
        if(dp[i][target] != -1) return dp[i][target];
        int take = func(i+1, target-nums[i], nums, dp);
        int skip = func(i+1, target, nums, dp);
        return dp[i][target] = take + skip;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        //saare elements positive hai
        //if target > sum then ofc it is not possible -> return 0
        //lets say my sum of elements is somewhere on the number line 0.......sum
        //and target is somewhere behind sum
        //some numbers in the array needs to become negative in order for the sum to become target..right? 
        //when lets say some x elements becomes neg, then remaining sum of elements = sum - x
        //x is positive here
        //so for my final array -> (sum-x) - x = target ...why? because some elements x have placed a minus sign in front of them. So, sum of rem elements = sum-x and that x elements needs to be added also but since they have placed a minus sign so x being positive it becomes (sum-x)-x = target
        //x = (sum-target)/2 
        //if sum-target is odd -> not possible -> return 0
        //if even, search for a subset of array which has a sum-target as total sum. It will be positive because sum >= target always so dp works here.

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(target > sum || (sum-target) % 2 == 1) return 0;
        int[][] dp = new int[n][(sum-target)/2 + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(0, (sum-target)/2, nums, dp);
    }
}