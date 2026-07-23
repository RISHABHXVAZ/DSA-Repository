class Solution {
    int count = 0;
    void merge(int start, int mid, int end, int[] nums){
        int[] temp = new int[end-start+1];
        int i = start, j = mid+1;
        int k = 0;
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i];
                i++;
            }else{
                temp[k++] = nums[j];
                j++;
            }
        }

        while(i <= mid){
            temp[k++] = nums[i];
            i++;
        }

        while(j <= end){
            temp[k++] = nums[j];
            j++;
        }

        for(int a = 0; a < temp.length; a++){
            nums[start+a] = temp[a];
        }

        return;
    }
    void countpair(int start, int mid, int end, int[] nums){
        int j = mid + 1;

        // Two pointers: both i and j only move forward (O(N) total)
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            // Add the count of valid elements in the right half for current nums[i]
            count += (j - (mid + 1));
        }
    }
    void mergesort(int i, int j, int[] nums){
        if(i >= j) return;

        int mid = (i + j)/2;

        mergesort(i, mid, nums);
        mergesort(mid+1, j, nums);
        countpair(i, mid, j, nums);
        merge(i, mid, j, nums);
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;

         mergesort(0, n-1, nums);
        return count;
    }
}