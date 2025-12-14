class Solution {
    static int func(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0, cnt = 0;
        while(j < n){
            sum += nums[j];
            while(sum > goal){
                sum -= nums[i];
                i++;
            }
            cnt += (j-i+1);
            j++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal) - func(nums, goal-1);
    }
}