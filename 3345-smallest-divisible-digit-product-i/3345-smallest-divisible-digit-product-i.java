class Solution {
    boolean check(int n, int t){
        int p = 1;
        while(n != 0){
            int x = n%10;
            p *= x;
            n /= 10;
        }

        if(p%t == 0) return true;
        return false;
    }
    public int smallestNumber(int n, int t) {
        int num = n;
        while(!check(num, t)){
            num++;
        }

        return num;
    }
}