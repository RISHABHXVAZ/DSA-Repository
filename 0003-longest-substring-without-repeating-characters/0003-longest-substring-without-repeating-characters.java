class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        
        int i = 0;
        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            while(i <= j && mpp.get(s.charAt(j)) > 1){
                mpp.put(s.charAt(i), mpp.get(s.charAt(i))-1);
                if(mpp.get(s.charAt(i)) == 0) mpp.remove(s.charAt(i));
                i++;
            }

            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}