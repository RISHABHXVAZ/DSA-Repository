class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int n = wordList.size();
        for(String s: wordList){
            st.add(s);
        }
        if(!st.contains(endWord)) return 0;

        int count = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        st.remove(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return count;
                for(int j = 0; j < word.length(); j++){
                    StringBuilder sb = new StringBuilder(word);
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        sb.setCharAt(j, ch);
                        if(st.contains(sb.toString())){
                            q.add(sb.toString());
                            st.remove(sb.toString());
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}