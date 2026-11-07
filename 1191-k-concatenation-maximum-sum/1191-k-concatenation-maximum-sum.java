class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int mod = 1000000007;
        
        long sum = 0;
        long total = 0;
        long maxsum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            total += (long)arr[i];

            sum += (long)arr[i];
            if(sum < 0) sum = 0;
            maxsum = Math.max(maxsum, sum);
        
        }
        if(k == 1) return (int)(maxsum % mod);

        long lprefix = 0;
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += (long)arr[i];
            lprefix = Math.max(sum, lprefix);
        }

        long lsuffix = 0;
        sum = 0;
        for(int i = n-1; i >= 0; i--){
            sum += (long)arr[i];
            lsuffix = Math.max(sum, lsuffix);
        }

        long ans = maxsum;
        if(total < 0){
            ans = Math.max(ans, lprefix+lsuffix);
        }else{
            ans = Math.max(ans, lprefix + lsuffix + (k-2)*total);
        }

        return (int)(ans % mod);
    }
}