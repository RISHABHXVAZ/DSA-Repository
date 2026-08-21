class Solution {
    long count(long x, long[] lcm, int[] sign, int subsets){
        long count = 0;
        for(int mask = 1; mask < subsets; mask++){
            count += sign[mask]*(x/lcm[mask]);
        }

        return count;
    }
    long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    long lcm(long a, long b){
        if(a==0||b==0) return 0;
        return (a/gcd(a,b)) * b;
    }
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int subsets = 1 << n;

        long[] lcm = new long[subsets];
        int[] sign = new int[subsets];

        for(int mask = 1; mask < subsets; mask++){
            int count = Integer.bitCount(mask);
            sign[mask] = count % 2 == 1 ? 1 : -1;

            long currlcm = 1;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0){
                    currlcm = lcm(currlcm, (long)coins[i]);
                }
            }

            lcm[mask] = currlcm;
        }

        int mincoin = coins[0];
        for(int i = 0; i < n; i++){
            mincoin = Math.min(mincoin, coins[i]);
        }

        long low = 1;
        long high = mincoin*(long)k;

        long ans = high;

        while(low <= high){
            long mid = low + (high-low)/2;
            if(count(mid, lcm, sign, subsets) >= k){
                ans = mid;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;
    }
}