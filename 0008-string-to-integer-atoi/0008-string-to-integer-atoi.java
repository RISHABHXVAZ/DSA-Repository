class Solution {
    int func(String s, int i, long result, int sign){
        if(i >= s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(sign*result);
        }
        
        result = result*10 + (s.charAt(i) - '0');

        if(sign*result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(sign*result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return func(s, i+1, result, sign);
    }
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = s.charAt(i) == '-' ? -1: 1;
            i++;
        }
        return func(s, i, 0, sign);
    }
}