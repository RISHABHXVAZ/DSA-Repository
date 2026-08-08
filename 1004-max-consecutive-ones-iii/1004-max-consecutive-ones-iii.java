class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int flipped = 0;
        int i = 0;
        int maxlen = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++){
           if(nums[j] == 0){
            flipped++;
           }

            while(i < n && flipped > k){
                if(nums[i] == 0) flipped--;
                i++;
            }

            maxlen = Math.max(maxlen, j-i+1);
        }

        return maxlen;
    }
}