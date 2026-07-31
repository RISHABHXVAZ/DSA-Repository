class Solution {
    boolean isPossible(int[] weights, int capacity, int days){
        int d = 1;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            if(sum + weights[i] <= capacity){
                sum += weights[i];
            }else{
                d++;
                sum = weights[i];
            }
        }

        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int total = 0;
        int max = -1;
        for(int i = 0; i < n; i++){
            total += weights[i];
            max = Math.max(max, weights[i]);
        }

        int ans = Integer.MAX_VALUE;
        int low = max, high = total;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(weights, mid, days)){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;
    }
}