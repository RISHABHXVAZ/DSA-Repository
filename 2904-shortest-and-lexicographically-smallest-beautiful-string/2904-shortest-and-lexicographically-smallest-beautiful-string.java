class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        List<String> temp = new ArrayList<>();

        int[] pref = new int[n];
        pref[0] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '0') pref[i] = pref[i-1];
            else pref[i] = pref[i-1] + 1;
        }

        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        
        int minlen = Integer.MAX_VALUE;
        String ans = "";

        for(int r = 0; r < n; r++){
            int target = pref[r] - k;
            if(mpp.containsKey(target)){
                int l = mpp.get(target)+1;
                int len = r-l+1;
                if(len < minlen){
                    ans = s.substring(l, r+1);
                    minlen = len;
                }else if(len == minlen){
                    String s1 = s.substring(l, r+1);
                    int x = s1.compareTo(ans);
                    if(x == -1) ans = s1;
                }
            }
            mpp.put(pref[r], r);
        }

        return ans;
        
    }
}