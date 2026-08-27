class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        if (n != target.length()) return "";

        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Try to match target as deeply as possible
        int matchLen = 0;
        while (matchLen < n) {
            int chIdx = target.charAt(matchLen) - 'a';
            if (count[chIdx] > 0) {
                count[chIdx]--;
                matchLen++;
            } else {
                break;
            }
        }

        // Backtrack from matchLen down to 0 to find the first index 
        // where we can pick a character strictly greater than target.charAt(i)
        for (int i = matchLen; i >= 0; i--) {
            // Restore character if we backtrack past a previously matched position
            if (i < matchLen) {
                count[target.charAt(i) - 'a']++;
            }

            if (i == n) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (count[c] > 0) {
                    // Valid pivot found
                    StringBuilder sb = new StringBuilder();
                    sb.append(target, 0, i);
                    sb.append((char) ('a' + c));
                    count[c]--;

                    // Append the rest in ascending order
                    for (int rem = 0; rem < 26; rem++) {
                        while (count[rem] > 0) {
                            sb.append((char) ('a' + rem));
                            count[rem]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return ""; // No lexicographically greater permutation possible
    }
}