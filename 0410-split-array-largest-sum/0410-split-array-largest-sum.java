class Solution {
    int partitions(int[] arr, int maxsum){
        int n = arr.length;
        int p = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + arr[i] <= maxsum){
                sum += arr[i];
            }else{
                sum = arr[i];
                p++;
            }
        }

        return p+1;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, max = -1;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int low = max, high = sum;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(partitions(nums, mid) <= k){
                high = mid-1;
                ans = mid;
            }else low = mid+1;
        }

        return ans;
    }
}