class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Map<Character, Integer> mpp = new HashMap<>();

        Set<Character> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                mpp.put(ch, i);
            }else{
                if(mpp.containsKey(ch)) continue;
                mpp.put(ch,i);
            }
        }
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                char cch = (char)(ch + 32);
                if(mpp.containsKey(cch) && mpp.get(cch) < mpp.get(ch) && !st.contains(ch)){
                    st.add(ch);
                }
            }
        }
        return st.size();
    }
}