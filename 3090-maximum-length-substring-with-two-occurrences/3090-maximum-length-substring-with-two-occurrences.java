class Solution {
    boolean valid(String s){
        int n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
            if(mpp.get(ch) > 2) return false;
        }

        return true;
    }
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = i; j < n; j++){
                str = str + s.charAt(j);
                if(valid(str)){
                    maxlen = Math.max(maxlen, j-i+1);
                }
            }
        }

        return maxlen;
    }
}