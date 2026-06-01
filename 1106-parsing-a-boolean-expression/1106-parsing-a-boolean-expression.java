class Solution {
    int index = 0;
    boolean parse_and(String expr){
        boolean ans = true;
        index++;
        while(expr.charAt(index) != ')'){
            if(expr.charAt(index) == ','){
                index++;
                continue;
            }

            ans &= parse(expr);
        }
        index++;
        return ans;
    }
    boolean parse_or(String expr){
        boolean ans = false;
        index++;
        while(expr.charAt(index) != ')'){
            if(expr.charAt(index) == ','){
                index++;
                continue;
            }
            ans |= parse(expr);
        }
        index++;
        return ans;
    }
    boolean parse_not(String expr){
        index++;
        boolean ans = !parse(expr);
        index++;
        return ans;
    }
    boolean parse(String expr){
        char ch = expr.charAt(index);
        index++;
        if(ch == 't') return true;
        if(ch == 'f') return false;

        if(ch == '&') return parse_and(expr);
        if(ch == '|') return parse_or(expr);
        else return parse_not(expr);
    }
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();

        return parse(expression);
    }
}