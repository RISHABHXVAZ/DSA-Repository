class Solution {
    public int tribonacci(int n) {
        int curr = 1, prev = 1, prev_prev = 0;
        if(n == 1) return prev;
        if(n == 2) return curr;
        int ans = 0;
        for(int i = 0; i < n-2; i++){
            ans = curr + prev + prev_prev;
            prev_prev = prev;
            prev = curr;
            curr = ans;
        }

        return ans;
    }
}