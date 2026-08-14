class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();

        int i = 0;
        int maxlen = 0;
        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch, 0)+1);

            while(i <= j && mpp.get(ch) > 2){
                mpp.put(s.charAt(i), mpp.get(s.charAt(i))-1);
                if(mpp.get(s.charAt(i)) == 0) mpp.remove(s.charAt(i));
                i++;
            }

            maxlen = Math.max(maxlen, j-i+1);   
        }

        return maxlen;
    }
}