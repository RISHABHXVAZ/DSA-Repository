class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        int maxidx = -1, minidx = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
                maxidx = i;
            }

            if(nums[i] < min){
                min = nums[i];
                minidx = i;
            }
        } 

        int i = Math.min(minidx, maxidx);
        int j = Math.max(minidx, maxidx);

        return Math.min(j+1, Math.min(n-i, i+1 + n-j));

    }
}