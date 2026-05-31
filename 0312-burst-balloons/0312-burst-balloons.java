class Solution {
    int func(int i, int j, int[] nums){
        if(i > j) return 0;
        int ans = Integer.MIN_VALUE;
        int steps = 0;
        for(int k = i; k <= j; k++){

            steps = nums[i-1]*nums[k]*nums[j+1] + func(i, k-1, nums) + func(k+1, j, nums);
            ans = Math.max(ans, steps);
        }
        return ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newarr = new int[n+2];
        newarr[0] = 1;
        newarr[n+1] = 1;
        for(int i = 1; i <= n; i++){
            newarr[i] = nums[i-1];
        }

        return func(1, n, newarr);
    }
}