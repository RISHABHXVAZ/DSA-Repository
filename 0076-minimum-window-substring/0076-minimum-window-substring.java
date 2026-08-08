class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> mpp = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        for(int i = 0; i < m; i++){
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int formed = 0;
        int ans = Integer.MAX_VALUE;
        int startI = -1, endI = -1;
        int i = 0;
        for(int j = 0; j < n; j++){
            char ch = s.charAt(j);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);

            if(target.containsKey(ch) && target.get(ch).intValue() == mpp.get(ch).intValue()){
                formed++;
            }
                while(i <= j && formed == target.size()){
                    if(j-i+1 < ans){
                    ans = j-i+1;
                    startI = i;
                    endI = j;
                    }
                    char ch1 = s.charAt(i);
                    mpp.put(ch1, mpp.get(ch1)-1);
                    if(mpp.get(ch1) == 0) mpp.remove(ch1);

                    if(target.containsKey(ch1) && (!mpp.containsKey(ch1) || mpp.get(ch1).intValue() < target.get(ch1).intValue())){
                        formed--;
                    }
                    i++;
                }
        }

        if(startI == -1 && endI == -1) return "";
        return s.substring(startI, endI+1);

    }
}