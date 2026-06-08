class Solution {
    void calculateLPS(String s, int[] lps){
        int len = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return;
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return s;
        int[] lps = new int[2*n + 1];
        String combined = s + '#' + new StringBuilder(s).reverse().toString();
        calculateLPS(combined, lps);

        int x = lps[combined.length()-1];
        String sub = s.substring(x);
        return new StringBuilder(sub).reverse().toString() + s;

    }
}