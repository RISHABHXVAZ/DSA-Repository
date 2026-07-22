class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        List<int[]> lst = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(lst.isEmpty() || intervals[i][0] > lst.get(lst.size()-1)[1]){
                lst.add(intervals[i]);
                continue;
            }

            int[] temp = lst.get(lst.size()-1);
            if(intervals[i][0] <= temp[1]){
                lst.remove(lst.size()-1);
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                lst.add(temp);
            }
        }

        int[][] ans = new int[lst.size()][2];
        int k = 0;
        for(int[] p : lst){
            ans[k++] = p;
        }
        
        return ans;
    }
}