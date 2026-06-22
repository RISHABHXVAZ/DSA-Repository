class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int[] freq = new int[255];
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            freq[ch-'a']++;
        }
        String s = "balloon";
        int ans = 0;
        int i = 0;
        while(freq[s.charAt(i)-'a'] > 0){
            freq[s.charAt(i)-'a']--;
            i++;
            if(i == 7){
                ans++;
                i = i % 7;
            }
        }

        return ans;
    }
}