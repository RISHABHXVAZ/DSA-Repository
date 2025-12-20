class Solution {
    static boolean neglectAndCheck(String s, int k){
        int n = s.length();
        int i = 0, j = n-1;
        while(i <= j){
            if(i == k){
                i++;
            }
            if(j == k){
                j--;
            }
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        int cnt = 0;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                if(neglectAndCheck(s,i)){
                    return true;
                }
                else return neglectAndCheck(s,j);
            }
        }
        return true;
    }
}