class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxlen = 0;
        int i = 0, j = 0;
        int flipped = 0;
        while(j < n){
            if(nums[j] == 1){
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
            }
            else{
                if(flipped < k){
                    flipped++;
                    maxlen = Math.max(maxlen, j - i + 1);
                    j++;
                }
                else{
                    if(nums[i] == 0) flipped--;
                    i++;
                }
            }
        }
        return maxlen;
    }
}