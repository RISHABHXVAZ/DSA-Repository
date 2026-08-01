class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> mpp = new HashMap<>();
        for(int i = 0; i < m; i++){
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0, j = 0;
        int formed = 0, ans = Integer.MAX_VALUE;
        int startI = -1, endI = -1;
        while(i < n && j < n){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);

            if(target.containsKey(ch) && mpp.containsKey(ch) && target.get(ch).intValue() == mpp.get(ch).intValue()){
                formed++;
            }

            while(formed == target.size()){
                if(j-i+1 < ans){
                    ans = j-i+1;
                    startI = i;
                    endI = j;
                }
                if(target.containsKey(s.charAt(i)) && mpp.get(s.charAt(i)).intValue() == target.get(s.charAt(i)).intValue()){
                    formed--;
                }
                mpp.put(s.charAt(i), mpp.get(s.charAt(i))-1);
                if(mpp.get(s.charAt(i)) == 0) mpp.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        if(startI == -1 && endI == -1) return "";
        return s.substring(startI, endI+1);
    }
}