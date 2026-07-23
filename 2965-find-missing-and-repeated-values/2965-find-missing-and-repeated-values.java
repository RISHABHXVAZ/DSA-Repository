class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        n = n*n;
        long asum = n*(n+1)/2;
        long asqsum = n*(n+1)*(2*n+1)/6;

        long csum = 0, csqsum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                csum += grid[i][j];
                csqsum += (grid[i][j]*grid[i][j]);
            }
        }

        long x = asum - csum;
        long y = asqsum - csqsum;

        long sum = y/x;

        long missing = (sum + x)/2;
        long rep = (sum-x)/2;

        return new int[]{ (int)rep, (int)missing};
    }
}