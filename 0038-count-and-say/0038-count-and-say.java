class Solution {
    String RLE(String s){
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length(); i++){
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                ans.append(count).append(s.charAt(i));
                count=1;
            }
        }

        return ans.toString();
    }
    public String countAndSay(int n) {
        if(n == 1) return "1";

        String temp = countAndSay(n-1);

        return RLE(temp);
    }
}