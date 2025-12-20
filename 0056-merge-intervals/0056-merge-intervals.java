class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> lst = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int[] temp;
        while(i < n){
            temp = intervals[i];
            while(i < n && intervals[i][0] <= temp[1] && intervals[i][1] >= temp[0]){
                temp[0] = Math.min(intervals[i][0], temp[0]);
                temp[1] = Math.max(intervals[i][1], temp[1]);
                i++;
            }
            lst.add(temp);
        }

        int[][] ans = new int[lst.size()][2];
        int k = 0;
        for(int[] j : lst){
            ans[k++] = j;
        }

        return ans;
    }
}