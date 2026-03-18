class Solution {
    long func(int x, long n){
        if(x == 0) return 0;
        if(n == 0) return 1;

        long half = func(x, n/2) % 1000000007;
        long temp = (half*half) % 1000000007;
        if(n % 2 == 0) return temp;
        else return (x*temp) % 1000000007;
    }
    public int countGoodNumbers(long n) {
        long ans;
        if(n % 2 == 0) ans = (func(5, n/2)* func(4, n/2)) % 1000000007;
        else ans = (func(5, n/2+1) * func(4, n/2)) % 1000000007;

        return (int)ans;
    }
}