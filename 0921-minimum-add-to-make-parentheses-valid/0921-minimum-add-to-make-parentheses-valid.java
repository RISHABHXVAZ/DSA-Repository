class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == ')' && !st.isEmpty() && st.peek() == '('){ 
                st.pop();
                continue;
            }

            st.push(ch);
        }

        return st.size();
    }
}