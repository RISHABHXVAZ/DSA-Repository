class Solution {
    double func(double x, int n){
        if(x == 0) return 0;
        if(n == 0) return 1;
        double half = func(x,n/2);
        if(n % 2 == 0) return half*half;
        else return x * half * half;
    }
    public double myPow(double x, int n) {
        if(n < 0) return 1.0/func(x,-1*n);
        else return func(x,n);
    }
}