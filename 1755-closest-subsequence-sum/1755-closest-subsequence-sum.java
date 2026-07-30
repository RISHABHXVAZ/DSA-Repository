import java.util.*;

class Solution {
    // Helper function generating subsets for range [start, end)
    void generatesubsets(int start, int end, int curr, List<Integer> lst, int[] nums) {
        if (start == end) {
            lst.add(curr);
            return;
        }

        // Include current element
        generatesubsets(start + 1, end, curr + nums[start], lst, nums);
        // Exclude current element
        generatesubsets(start + 1, end, curr, lst, nums);
    } 

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        // Left half range: [0, mid)
        List<Integer> leftsum = new ArrayList<>();
        generatesubsets(0, mid, 0, leftsum, nums);

        // Right half range: [mid, n)
        List<Integer> rightsum = new ArrayList<>();
        generatesubsets(mid, n, 0, rightsum, nums);

        // Sort right half for binary search
        Collections.sort(rightsum);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < leftsum.size(); i++) {
            int sum1 = leftsum.get(i);
            int sum2 = goal - sum1;

            int idx = Collections.binarySearch(rightsum, sum2);

            // Exact match found!
            if (idx >= 0) return 0;

            int insertion = -idx - 1;

            // Element just larger than sum2
            if (insertion < rightsum.size()) {
                ans = Math.min(ans, Math.abs(goal - (sum1 + rightsum.get(insertion))));
            }

            // Element just smaller than sum2
            if (insertion > 0) {
                ans = Math.min(ans, Math.abs(goal - (sum1 + rightsum.get(insertion - 1))));
            }
        }

        return ans;
    }
}