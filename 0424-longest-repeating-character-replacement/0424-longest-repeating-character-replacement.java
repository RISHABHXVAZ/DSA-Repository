class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxlen = 0;
        int maxfreq = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        int i = 0;
        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
            maxfreq = Math.max(maxfreq, mpp.get(ch));

            while(j-i+1 - maxfreq > k){
                mpp.put(s.charAt(i), mpp.get(s.charAt(i))-1);
                i++;
            }

            maxlen = Math.max(maxlen, j-i+1);
        }

        return maxlen;
    }
}