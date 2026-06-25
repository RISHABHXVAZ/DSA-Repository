class Solution {
 
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int cnt1 = 0;
        for(int i = 0; i < n; i++){
             int cnt2 = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == target) cnt2++;
                else cnt2--;
                if(cnt2 > 0) cnt1++;
            }
        }
        return cnt1;
        
    }
}