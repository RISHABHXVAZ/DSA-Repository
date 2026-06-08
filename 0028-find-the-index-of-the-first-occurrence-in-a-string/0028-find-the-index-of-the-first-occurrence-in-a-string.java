class Solution {
    void buildLPSArray(String s, int[] lps){
        int len = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0) {
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return;
    }
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        int[] lps = new int[n2];
        buildLPSArray(needle, lps);

        int i = 0, j = 0, k = 0;
        while(i < n1){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == n2) return i - n2;
            else if(i < n1 && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                   i++;
                }
            }
        }
        return -1; 
    }
}