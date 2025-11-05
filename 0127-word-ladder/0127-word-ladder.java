class Solution {
    class Pair {
        String first;
        int second;
        Pair(String f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // endWord must exist

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}
