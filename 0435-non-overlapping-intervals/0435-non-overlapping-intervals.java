class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int count = 0;
        int[] last = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i = 0; i < n; i++){
            if(intervals[i][0] >= last[1]){
                last[0] = intervals[i][0];
                last[1] = intervals[i][1];
            }else{
                count++;
            }
        }

        return count;

    }
}