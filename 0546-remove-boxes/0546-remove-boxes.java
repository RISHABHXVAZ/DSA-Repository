class Solution {
    int func(int i, int j, int k, int[] boxes, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        // Save original starting point for memoization
        int originalI = i;
        int originalK = k;

        // Compress contiguous identical boxes at the start
        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }

        // Option 1: Cash out the current compressed block immediately
        int maxPoints = (k + 1) * (k + 1) + func(i + 1, j, 0, boxes, dp);

        // Option 2: Try merging with another matching box at index m
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                int op2 = func(i + 1, m - 1, 0, boxes, dp) + func(m, j, k + 1, boxes, dp);
                maxPoints = Math.max(maxPoints, op2);
            }
        }

        // Memoize using the ORIGINAL parameters (originalI and originalK)
        dp[originalI][j][originalK] = maxPoints;
        return dp[originalI][j][originalK];
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return func(0, n - 1, 0, boxes, dp);
    }
}