class Solution {
    static String removeLeadingZeros(String str){
        StringBuilder ans = new StringBuilder();
        boolean nonZeroDigitGot = false;
        for(int i = 0; i < str.length(); i++){
            if(nonZeroDigitGot == false && str.charAt(i) == '0'){
                continue;
            }
            
            if(nonZeroDigitGot == false && str.charAt(i) != '0'){
                nonZeroDigitGot = true;
            }
            ans.append(str.charAt(i));
        }
        if(ans.isEmpty()) ans.append("0");
        return ans.toString();
    }
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n || (k == 1 && n == 1)) return "0";

        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && k > 0 && Character.getNumericValue(st.peek()) >  Character.getNumericValue(num.charAt(i))){
                st.pop();
                k--;
            }
            if(k == 0){
                while(i < n){
                    st.push(num.charAt(i));
                    i++;
                }
                break;
            }
            else st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }

        String ans = removeLeadingZeros(sb.reverse().toString());
        return ans;
    }
}