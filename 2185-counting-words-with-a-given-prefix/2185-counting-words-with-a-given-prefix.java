class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String word = words[i];

            int a = 0, b = 0;
            boolean flag = true;
            while(a < word.length() && b < pref.length()){
                if(word.charAt(a) != pref.charAt(b)){ 
                    flag = false;
                    break;
                }
                a++;
                b++;
            }

            if(flag == false || b < pref.length() ) continue;
            else cnt++;
        }

        return cnt;
    }
}