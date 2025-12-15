class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] hash = new int[256];
        for(int i = 0; i < n; i++){
           hash[t.charAt(i)]++;
        }
        int i = 0, j = 0, minlen = Integer.MAX_VALUE;
        int cnt = 0;
        int startIndex = -1, endIndex = -1;
        while(j < m){
            if(hash[s.charAt(j)] > 0) cnt++;
            hash[s.charAt(j)]--;
            while(cnt == n){
                if(j-i+1 < minlen){
                    minlen = j-i+1;
                    startIndex = i;
                    endIndex = j;
                }
                hash[s.charAt(i)]++;
                if(hash[s.charAt(i)] > 0) cnt--;
                i++;
            }
            j++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex,endIndex+1);
    }
}