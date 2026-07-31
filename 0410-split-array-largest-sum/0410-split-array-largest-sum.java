class Solution {
    int divisions(int[] nums, int maxsum){
        int sum = 0;
        int div = 1;

        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] <= maxsum){
                sum += nums[i];
            }else{
                sum = nums[i];
                div++;
            }
        }

        return div;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = -1, sum = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int low = max, high = sum;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(divisions(nums, mid) <= k){
                high = mid-1;
            }else low = mid+1;
        }

        return low;
    }
}