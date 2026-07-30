class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for(int i = 0; i < bookings.length; i++){
            int f = bookings[i][0];
            int l = bookings[i][1];
            int s = bookings[i][2];

            diff[f-1] += s;
            if(l < n) diff[l] -= s;
        }

        for(int i = 1; i < n; i++){
            diff[i] = diff[i-1] + diff[i];
        }

        return diff;
    }
}