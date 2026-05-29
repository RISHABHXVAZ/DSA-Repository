class Solution {
    boolean ispredecessor(String s2, String s1){
        if(s1.length() - s2.length() != 1) return false;

        int i = 0, j = 0, cnt = 0;
        while(i < s2.length() && j < s1.length()){
            char ch1 = s2.charAt(i);
            char ch2 = s1.charAt(j);
            if(ch1 == ch2){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;

        int[] dp = new int[n];
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 0; i < n; i++){
            String s1 = words[i];
            for(int j = 0; j < i; j++){
                String s2 = words[j];
                if(ispredecessor(s2, s1) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}