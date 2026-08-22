class Solution {
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the first decreasing element from right
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        // Step 2 & 3: If pivot exists, find successor from right and swap
        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[pivot];
                    nums[pivot] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }

        // Step 4: Reverse the suffix starting at pivot + 1
        reverse(nums, pivot + 1, n - 1);
    }
}