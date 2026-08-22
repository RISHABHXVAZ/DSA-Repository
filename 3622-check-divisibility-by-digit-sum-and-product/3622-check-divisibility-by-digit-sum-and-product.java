class Solution {
    public boolean checkDivisibility(int n) {
        int copy = n;
        int sd = 0, pd = 1;

        while(copy != 0){
            int x = copy % 10;
            sd += x;
            pd *= x;
            copy /= 10;
        }

        return n % (sd+pd) == 0;
    }
}