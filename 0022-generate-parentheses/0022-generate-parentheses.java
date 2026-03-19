class Solution {
    void func(StringBuilder sb, int open, int close, int n, List<String> ans){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            func(sb, open+1, close, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > close){
            sb.append(")");
            func(sb, open, close+1, n, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        func(sb, 0, 0,n, ans);
        return ans;
    }
}