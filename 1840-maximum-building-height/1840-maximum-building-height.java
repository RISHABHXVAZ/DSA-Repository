class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1,0});
        
        for(int[] temp : restrictions){
            res.add(temp);
        }

        if(res.get(res.size()-1)[0] != n) res.add(new int[]{n, n-1});

        Collections.sort(res, (a,b)->a[0]-b[0]);
        int m = res.size();

        for(int i = 1; i < m; i++){
            int[] prev = res.get(i-1);
            int[] curr = res.get(i);

            curr[1] = Math.min(curr[1], prev[1] + (curr[0]-prev[0]));
        }

        for(int i = m-2; i >= 0; i--){
            int[] prev = res.get(i+1);
            int[] curr = res.get(i);

            curr[1] = Math.min(curr[1], prev[1] + (prev[0]-curr[0]));
        }

        int ans = -1;
        for(int i = 1; i < m; i++){
            int[] prev = res.get(i-1);
            int[] curr = res.get(i);
            int distance = curr[0]-prev[0];
            int peak = (curr[1] + prev[1] + distance) / 2;
            ans = Math.max(ans, peak);
        }

        return ans;
    }
}