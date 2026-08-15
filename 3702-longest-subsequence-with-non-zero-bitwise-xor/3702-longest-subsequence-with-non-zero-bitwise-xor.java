class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalxor = 0;
        for(int num : nums){
            totalxor = totalxor^num;
        }

        if(totalxor != 0) return n;

        int flag = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                flag = 1;
                break;
            }
        }
        if(flag == 0) return 0;
        else return n-1;
    }
}