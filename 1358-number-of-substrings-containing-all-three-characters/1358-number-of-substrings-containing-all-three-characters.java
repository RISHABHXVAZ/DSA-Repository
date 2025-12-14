class Solution {
    public int numberOfSubstrings(String s){
        int n = s.length();
        int i = 0, j = 0;
        int[] freq = new int[3];
        int count = 0;
        while(j < n){
            freq[s.charAt(j) - 'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += (n-j);

                freq[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return count;
    }
}