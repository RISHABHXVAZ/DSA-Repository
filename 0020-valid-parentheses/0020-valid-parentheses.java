class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char ch2 = st.peek();
                if(ch == ')' && ch2 == '(') st.pop();
                else if(ch == '}' && ch2 == '{') st.pop();
                else if(ch == ']' && ch2 == '[') st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }
}