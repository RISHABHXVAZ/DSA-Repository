class Solution {
    public int passwordStrength(String password) {
        int n = password.length();
        Map<Character, Integer> mpp = new HashMap<>();
        String s = "";
        for(int i = 0; i < n; i++){
            char ch = password.charAt(i);
            if(mpp.containsKey(ch)) continue;
            s += ch;
            mpp.put(ch, 1);
        }

        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') ans += 1;
            else if(ch >= 'A' && ch <= 'Z') ans += 2;
            else if(ch >= '0' && ch <= '9') ans += 3;
            else ans += 5;
        }
        return ans;
    }
}