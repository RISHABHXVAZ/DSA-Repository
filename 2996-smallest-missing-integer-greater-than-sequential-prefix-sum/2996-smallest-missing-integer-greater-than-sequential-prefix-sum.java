import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Put all elements into a HashSet for O(1) lookups
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        
        // Step 2: Compute the sum of the longest sequential prefix starting at index 0
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            ans += nums[i];
        }
        
        // Step 3: Find the smallest integer >= ans that is NOT in numsSet
        while (numsSet.contains(ans)) {
            ans++;
        }
        
        return ans;
    }
}