class Solution {
    void calculateZ(String s, int[] z){
        int l = 0, r = 0;
        
        for(int i = 1; i < s.length(); i++){
            if(i <= r){
                z[i] = Math.min(r-i+1, z[i-l]);
            }

            while(i + z[i] < s.length() && s.charAt(z[i]) == s.charAt(i + z[i])){
                z[i]++;
            }

            if(i+z[i]-1 > r){
                l = i;
                r = i+z[i]-1;
            }
        }

        return;
    }
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        String combined = needle + '$' + haystack;

        int[] z = new int[n1+n2+1];

        calculateZ(combined, z);

        for(int i = n2+1; i < n1+n2+1; i++){
            if(z[i] == n2) return i-n2-1;
        }
        return -1;
    }
}