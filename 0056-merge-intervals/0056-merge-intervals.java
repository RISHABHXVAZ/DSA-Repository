class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                continue;
            }

            List<Integer> last = ans.get(ans.size()-1);
            last.set(0, Math.min(last.get(0), intervals[i][0]));
            last.set(1, Math.max(last.get(1), intervals[i][1]));
        }

        int[][] res = new int[ans.size()][2];
        int k = 0;
        for(List<Integer> temp : ans){
            res[k][0] = temp.get(0);
            res[k][1] = temp.get(1);
            k++; 
        }

        return res;
    }
}