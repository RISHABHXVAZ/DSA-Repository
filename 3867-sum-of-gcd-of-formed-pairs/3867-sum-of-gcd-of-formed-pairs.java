class Solution {
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int[] mx = new int[n];
        mx[0] = nums[0];
        for(int i = 1; i < n; i++){
            mx[i] = Math.max(nums[i], mx[i-1]);
        }

        int[] prefixgcd = new int[n];
        for(int i = 0; i < n; i++){
            prefixgcd[i] = gcd(nums[i], mx[i]);
        }

        Arrays.sort(prefixgcd);

        int i = 0, j = n-1;
        long ans = 0;
        while(i < j){
            ans += gcd(prefixgcd[i], prefixgcd[j]);
            i++;
            j--;
        }

        return ans;
    }
}