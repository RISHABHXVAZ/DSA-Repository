class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = Integer.MIN_VALUE;
        int n = s.length();
        if(n == 0 || n == 1) return n;
        Set<Character> st = new HashSet<>();
        int i = 0, j = 0;
        while(j < n){
            char ch = s.charAt(j);
            if(!st.contains(ch)){
                st.add(ch);
                maxlen = Math.max(maxlen, j-i+1);
                j++;
            }
            else{
                st.remove(s.charAt(i));
                i++;
            }
        }
       
        return maxlen;
    }
}