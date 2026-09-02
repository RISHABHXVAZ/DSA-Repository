class Solution {
    public int longestSubarray(int[] nums) {
     int n = nums.length;
     int maxlen = 0;

    int sum = 0;
    int i = 0;
     for(int j = 0; j < n; j++){
        sum += nums[j];

        while(sum < (j-i+1)-1){
            sum -= nums[i];
            i++;
        }

        maxlen = Math.max(maxlen, j-i+1);
     }

     return maxlen-1;   
    }
}