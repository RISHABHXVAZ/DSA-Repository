class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int start = 0, end , maxlen = Integer.MIN_VALUE;
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(start < n){
            end = start;
            while(end < n && !mpp.containsKey(s.charAt(end))){
                mpp.put(s.charAt(end), 1);
                end++;
            }
            int len = end-start;
            if(len > maxlen) maxlen = len;
            mpp.clear();
            start = start+1;
        }
        return maxlen;
    }
}