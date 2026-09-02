import java.util.*;

class Solution {
    String formatString(String sb, int maxWidth, boolean isLastLine) {
        // Trim leading/trailing spaces added during greedy accumulation
        sb = sb.trim();
        // Split by 1 or more spaces so multiple spaces don't produce empty tokens
        String[] words = sb.split("\\s+");

        int letterCount = 0;
        for (String word : words) {
            letterCount += word.length();
        }

        int vacant = words.length - 1;

        // Case 1: Single word line OR Last line -> Left-justify
        if (vacant == 0 || isLastLine) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                ans.append(words[i]);
                if (i < vacant) {
                    ans.append(" ");
                }
            }
            // Pad remaining spaces to the right until maxWidth is reached
            while (ans.length() < maxWidth) {
                ans.append(" ");
            }
            return ans.toString();
        }

        // Case 2: Middle lines with 2+ words -> Evenly distribute spaces
        int totalSpaces = maxWidth - letterCount;
        int base = totalSpaces / vacant;
        int r = totalSpaces % vacant;

        int[] spaces = new int[vacant];
        Arrays.fill(spaces, base);
        for (int i = 0; i < r; i++) {
            spaces[i]++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            ans.append(words[i]);
            if (i < vacant) {
                for (int s = 0; s < spaces[i]; s++) {
                    ans.append(" ");
                }
            }
        }

        return ans.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        String currentLine = "";

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            // If line is empty, seed it with the first word directly (no leading space)
            if (currentLine.isEmpty()) {
                currentLine = s;
            } else if (currentLine.length() + 1 + s.length() <= maxWidth) {
                currentLine = currentLine + " " + s;
            } else {
                // Format the completed line
                ans.add(formatString(currentLine, maxWidth, false));
                // Do not drop the current word; start the next line with it
                currentLine = s;
            }
        }

        // Handle the final accumulated line (left-justified)
        if (!currentLine.isEmpty()) {
            ans.add(formatString(currentLine, maxWidth, true));
        }

        return ans;
    }
}