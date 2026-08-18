class Solution {
    String expand(int i, int j, String s){
        int n = s.length();
        while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            //odd length palindromes
            String s1 = expand(i,i,s);

            //even length palindromes
            String s2 = expand(i, i+1, s);

            if(s1.length() > s2.length()){
                if(s1.length() > ans.length()) ans = s1;
            }else{
                if(s2.length() > ans.length()) ans = s2;
            }
        }

        return ans;
    }
}