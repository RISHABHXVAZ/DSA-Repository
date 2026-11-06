class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxp = nums[0];
        int minp = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] < 0){
                int temp = maxp;
                maxp = minp;
                minp = temp;
            }
            maxp = Math.max(nums[i], maxp*nums[i]);
            minp = Math.min(nums[i], minp*nums[i]);
            ans = Math.max(ans, maxp);
        }

        return ans;
    }
}