class Solution {
    int bouquets(int[] bloomDay, int day, int k){
        int n = bloomDay.length;
        int b = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] > day){ 
                count = 0;
            }else if(bloomDay[i] <= day){
                count++;
                if(count == k){
                    b++;
                    count = 0;
                }
            }
        }

        return b;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < k*m) return -1;

        int high = -1, low = 1;
        for(int i = 0; i < n; i++){
            high = Math.max(bloomDay[i], high);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(bouquets(bloomDay, mid, k) >= m){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;

    }
}