class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;
        int cnt = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int prevEnd = intervals[0][1];
        for(int i = 0; i < n; i++){
            if(intervals[i][0] >= prevEnd){
                cnt++;
                prevEnd = intervals[i][1];
            }
        }

        return n-cnt-1;
    }
}