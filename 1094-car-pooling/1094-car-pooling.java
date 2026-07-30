class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        int[] diff = new int[1100];
        for(int i = 0; i < n; i++){
            int np = trips[i][0];
            int f = trips[i][1];
            int t = trips[i][2];
            if(np > capacity) return false;
            diff[f] += np;
            diff[t] -= np;
        }

        for(int i = 1; i < 1100; i++){
            diff[i] = diff[i-1] + diff[i];
            if(diff[i] > capacity) return false;
        }
        return true;
    }
}