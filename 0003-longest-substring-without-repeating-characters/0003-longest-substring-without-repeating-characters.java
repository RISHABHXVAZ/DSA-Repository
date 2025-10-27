class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int start = 0, end = 0 , maxlen = Integer.MIN_VALUE;
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(end < n){
            if(mpp.containsKey(s.charAt(end))){
                if(mpp.get(s.charAt(end)) >= start){
                    start = mpp.get(s.charAt(end)) + 1;
                }
            }
            int len = end - start + 1;
            if(len > maxlen) maxlen = len;
            mpp.put(s.charAt(end), end);
            end++;
        }
        return maxlen;
    }
}