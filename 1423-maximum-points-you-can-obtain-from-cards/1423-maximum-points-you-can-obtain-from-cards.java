class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += cardPoints[i];
        }
        int sum = 0, minsum = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(j < n){
            sum += cardPoints[j];
            while(j-i+1 > n-k){
                sum -= cardPoints[i];
                i++;
            }
            if(j-i+1 == n-k) minsum = Math.min(minsum, sum);
            j++;
        }

        return total - minsum;
    }
}