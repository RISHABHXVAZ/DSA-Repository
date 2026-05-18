class Solution {
    int func(int idx, int[] nums, int target){
        if(idx == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(nums[idx] == target || nums[idx] == -target) return 1;
            else return 0;
        }
        
        int addplus = func(idx-1, nums, target - nums[idx]);
        int addminus = func(idx-1, nums, target + nums[idx]);
        return addplus + addminus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        
        return func(n-1, nums,target);
    }
}