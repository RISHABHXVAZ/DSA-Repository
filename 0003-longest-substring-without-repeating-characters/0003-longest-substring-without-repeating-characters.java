class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i = 0, j = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        int ans = 0;
        while (i < n && j < n) {
            char ch = s.charAt(j);
            if (mpp.containsKey(ch)) {
                mpp.put(s.charAt(i), mpp.get(s.charAt(i)) - 1);
                if (mpp.get(s.charAt(i)) == 0)
                    mpp.remove(s.charAt(i));
                i++;
            } else {
                mpp.put(ch, 1);
                ans = Math.max(ans, j - i + 1);
                j++;
            }
        }

        return ans;
    }
}