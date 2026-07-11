class Solution {
    List<Integer> func(String s){
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                List<Integer> left = func(s.substring(0, i));
                List<Integer> right = func(s.substring(i+1));

                for(int num1 : left){
                for(int num2 : right){
                    if(ch == '+') result.add(num1 + num2);
                    if(ch == '-') result.add(num1 - num2);
                    if(ch == '*') result.add(num1 * num2);
                }
            }
            }
        }

        if(result.isEmpty()) result.add(Integer.parseInt(s));

        return result;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return func(expression);
    }
}