import java.util.Arrays;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n1 = landStartTime.length;
        int n2 = waterStartTime.length;

        int[][] land = new int[n1][2];
        int[][] water = new int[n2][2];

        for (int i = 0; i < n1; i++) land[i] = new int[]{landStartTime[i], landDuration[i]};
        for (int i = 0; i < n2; i++) water[i] = new int[]{waterStartTime[i], waterDuration[i]};

        // Sort both by their start times
        Arrays.sort(land, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(water, (a, b) -> Integer.compare(a[0], b[0]));

        // Try both orderings: Land then Water, vs Water then Land
        return Math.min(solve(land, water), solve(water, land));
    }

    private int solve(int[][] first, int[][] second) {
        int m = second.length;
        
        int[] secondStarts = new int[m];
        for (int i = 0; i < m; i++) secondStarts[i] = second[i][0];

        // prefixMinDuration[i] stores the minimum duration among second[0...i]
        int[] prefixMinDuration = new int[m];
        prefixMinDuration[0] = second[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] = Math.min(prefixMinDuration[i - 1], second[i][1]);
        }

        // suffixMinEndTime[i] stores the minimum (Start + Duration) among second[i...m-1]
        int[] suffixMinEndTime = new int[m];
        suffixMinEndTime[m - 1] = second[m - 1][0] + second[m - 1][1];
        for (int i = m - 2; i >= 0; i--) {
            suffixMinEndTime[i] = Math.min(suffixMinEndTime[i + 1], second[i][0] + second[i][1]);
        }

        int minOverallFinish = Integer.MAX_VALUE;

        // For each task in the 'first' array, find the best matching task in 'second'
        for (int i = 0; i < first.length; i++) {
            int firstFinish = first[i][0] + first[i][1];

            // Binary search to find the first index where second task starts >= firstFinish
            int idx = lowerBound(secondStarts, firstFinish);

            // Case 1: Second task starts AFTER the first task finishes (S >= F)
            // Timeline: [First Task] ---> (Waiting Gap) ---> [Second Task]
            if (idx < m) {
                minOverallFinish = Math.min(minOverallFinish, suffixMinEndTime[idx]);
            }

            // Case 2: Second task was already available BEFORE the first task finished (S < F)
            // Timeline: [First Task][Second Task starts immediately here]
            if (idx > 0) {
                int bestWaitingDuration = prefixMinDuration[idx - 1];
                minOverallFinish = Math.min(minOverallFinish, firstFinish + bestWaitingDuration);
            }
        }

        return minOverallFinish;
    }

    // Helper to find the first index where array[index] >= target
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}