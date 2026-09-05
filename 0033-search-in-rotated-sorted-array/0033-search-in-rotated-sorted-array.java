class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = -1;

        for(int i = 0; i < n-1; i++){
            if(nums[i] > nums[i+1]){
                pivot = i;
                break;
            }
        }

        int low = 0, high = pivot;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }

        low = pivot+1; high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }

        return -1;
    }
}