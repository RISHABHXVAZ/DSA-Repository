class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int result = 0;
        long currSum = 0;
        Arrays.sort(nums);

        for(int r = 0; r < n; r++){
            long target = nums[r];
            currSum += target;

            while((r-l+1)*target - currSum > k){
                currSum -= nums[l];
                l++;
            }

            result = Math.max(result, r-l+1);
        }
        return result;
    }
}