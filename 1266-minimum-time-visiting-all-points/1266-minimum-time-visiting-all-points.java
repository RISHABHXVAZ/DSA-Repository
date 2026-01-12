class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;
        for(int i = 0; i < n-1; i++){
            int[] source = points[i];
            int[] dest = points[i+1];
            int sx = source[0];
            int sy = source[1];
            int dx = dest[0];
            int dy = dest[1];
            time += Math.max(Math.abs(sx-dx), Math.abs(sy-dy));
        }
        return time;
    }
}