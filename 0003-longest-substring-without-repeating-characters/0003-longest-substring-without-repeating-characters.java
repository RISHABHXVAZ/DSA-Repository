class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> mpp = new HashMap<>();
        int maxlen = 0;
        int i = 0, j = 0;

        while (j < n) {
            char ch = s.charAt(j);
            if (!mpp.containsKey(ch)) {
                mpp.put(ch, j);
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
                continue;
            }else{
                mpp.remove(s.charAt(i));
                i++;
            }
        }

        return maxlen;
    }
}