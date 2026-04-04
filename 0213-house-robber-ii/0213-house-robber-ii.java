class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] money = new int[n];
        //house 0 se house[n-2] tk
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i <= n-2; i++){
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
        }
        int v1 = money[n-2];

        //house 1 se house[n-1] tk
        money[1] = nums[1];
        money[2] =  Math.max(nums[1], nums[2]);;
        for(int i = 3; i <= n-1; i++){
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
        }
        return (int)Math.max(v1, money[n-1]);
    }
}