class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) return "";

        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        int minlen = Integer.MAX_VALUE;
        int startIndex = -1;

        int i = 0;
        int count = m; // Tracks total required characters

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            // If ch is part of t and still needed, reduce count
            if (mpp.containsKey(ch)) {
                if (mpp.get(ch) > 0) count--;
                mpp.put(ch, mpp.get(ch) - 1);
            }

            // Shrink window while it contains all characters of t
            while (count == 0) {
                if (j - i + 1 < minlen) {
                    minlen = j - i + 1;
                    startIndex = i;
                }

                char ch2 = s.charAt(i);
                if (mpp.containsKey(ch2)) {
                    mpp.put(ch2, mpp.get(ch2) + 1);
                    // If count of ch2 becomes > 0, we now lack a needed char
                    if (mpp.get(ch2) > 0) count++;
                }
                i++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minlen);
    }
}