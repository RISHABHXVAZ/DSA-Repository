class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        long largest = Long.MIN_VALUE;
        long slargest = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) nums[i] *= -1;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] >= largest){
                slargest = largest;
                largest = nums[i];
            }
            if(nums[i] >= slargest && nums[i] < largest){
                slargest = nums[i];
            }
        }
        long prod = largest * slargest;
        if(prod < 0) prod *= -1L*(long)Math.pow(10,5);
        else prod *= (long)Math.pow(10,5);

        return prod;
    }
}