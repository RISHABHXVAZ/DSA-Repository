class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < min) min = nums[j];
                if(nums[j] > max) max = nums[j];
                sum += (max-min);
            }
        }
        return sum;
    }
}