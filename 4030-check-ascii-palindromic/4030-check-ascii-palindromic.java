class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();

        int i = 0;
        int j = n-1;

        while(i <= j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            for(int k = 0; k < 8; k++){
                int x = ((int)ch1 >> (7-k)) & 1;
                int y = ((int)ch2 >> k) & 1;
                if(x != y) return false;
            }

            i++;
            j--;
        }

        return true;
    }
}