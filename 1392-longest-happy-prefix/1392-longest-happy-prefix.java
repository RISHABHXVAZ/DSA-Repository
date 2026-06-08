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
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        calculateLPS(s, lps);
        int len = lps[s.length()-1];
        return s.substring(0, len);
    }
}