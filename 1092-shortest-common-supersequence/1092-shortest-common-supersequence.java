class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = l1, j = l2;
        while(i >= 1 && j >= 1){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;j--;
            }else{
                if(dp[i][j-1] > dp[i-1][j]){
                    ans.append(str2.charAt(j-1));
                    j = j-1;
                }else{
                    ans.append(str1.charAt(i-1));
                    i = i-1;
                }
            }
        }

        while(i >= 1){ 
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j >= 1){ 
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
}