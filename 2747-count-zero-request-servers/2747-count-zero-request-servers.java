class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> a[1]-b[1]);
        int[][] sortedq = new int[queries.length][2];

        for(int i = 0; i < queries.length; i++){
            sortedq[i][0] = queries[i];
            sortedq[i][1] = i;
        }

        Arrays.sort(sortedq, (a,b) -> a[0]-b[0]);
        int[] ans = new int[queries.length];
        int left = 0, right = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < sortedq.length; i++){
            while(right < logs.length && logs[right][1] <= sortedq[i][0]){
                mpp.put(logs[right][0], mpp.getOrDefault(logs[right][0],0)+1);
                right++;
            }

            while(left < logs.length && logs[left][1] < sortedq[i][0]-x){
                mpp.put(logs[left][0], mpp.get(logs[left][0])-1);
                if(mpp.get(logs[left][0]) == 0) mpp.remove(logs[left][0]);
                left++;
            }

            ans[sortedq[i][1]] = n - mpp.size();
        }

        return ans;
    }
}