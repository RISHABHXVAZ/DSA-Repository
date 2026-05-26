class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Character> mpp = new HashMap<>();
        int n = word.length();
        int[] freq = new int[255];
        Set<Character> st = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            char ch = word.charAt(i);
            char cch = '0';
            if(ch >= 'a' && ch <= 'z'){
                cch = (char)(ch - 32);
            }else cch = (char)(ch + 32);

            if(freq[cch] > 0){
                if(!st.contains(ch)){
                    st.add(ch);
                    st.add(cch);
                }
            }else{
                freq[ch]++;
            }
            
        }

        
        return st.size()/2;
    }
}