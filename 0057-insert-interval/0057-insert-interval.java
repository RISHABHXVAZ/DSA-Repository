class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> lst = new ArrayList<>();

        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            lst.add(intervals[i]);
            i++;
        }

        while(i < n && !(intervals[i][1] < newInterval[0]) && !(intervals[i][0] > newInterval[1])){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        lst.add(newInterval);

        while(i < n && intervals[i][0] > newInterval[1]){
            lst.add(intervals[i]);
            i++;
        }

        int k = 0;
        int[][] ans = new int[lst.size()][2];
        for(int[] num : lst){
            ans[k++] = num;
        }

        return ans;
    }
}