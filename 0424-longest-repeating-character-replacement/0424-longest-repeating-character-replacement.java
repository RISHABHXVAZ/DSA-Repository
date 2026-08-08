class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();
        int i = 0;
        int maxlen = 0;

        int maxFreq = 0;
        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
           maxFreq = Math.max(maxFreq, mpp.get(ch));
            while ((j - i + 1) - maxFreq > k) {
                char leftChar = s.charAt(i);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
        }

        return maxlen;
    }
}