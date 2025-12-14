class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int maxfreq = 0, maxlen = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        while(j < n){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch,0) + 1);
            if(mpp.get(ch) > maxfreq) maxfreq = mpp.get(ch);
            while((j-i+1) - maxfreq > k){
                mpp.put(s.charAt(i), mpp.get(s.charAt(i)) - 1);
                i++;
            }
            maxlen = Math.max(maxlen, j - i + 1);
            j++;
        }
        return maxlen;
    }
}