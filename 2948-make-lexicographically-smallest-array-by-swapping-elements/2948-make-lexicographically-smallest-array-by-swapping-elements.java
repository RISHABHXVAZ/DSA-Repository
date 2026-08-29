import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Pair values with their original indices
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Sort pairs primarily by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        List<Integer> groupVals = new ArrayList<>();
        List<Integer> groupIndices = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // If the difference between adjacent sorted elements exceeds limit, process previous group
            if (!groupVals.isEmpty() && pairs[i][0] - groupVals.get(groupVals.size() - 1) > limit) {
                Collections.sort(groupIndices);
                for (int j = 0; j < groupVals.size(); j++) {
                    result[groupIndices.get(j)] = groupVals.get(j);
                }
                groupVals.clear();
                groupIndices.clear();
            }
            
            groupVals.add(pairs[i][0]);
            groupIndices.add(pairs[i][1]);
        }
        
        // Process the final remaining group
        if (!groupVals.isEmpty()) {
            Collections.sort(groupIndices);
            for (int j = 0; j < groupVals.size(); j++) {
                result[groupIndices.get(j)] = groupVals.get(j);
            }
        }
        
        return result;
    }
}