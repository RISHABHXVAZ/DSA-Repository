class Solution {
    public int[] validSequence(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[] last = new int[n2];
        Arrays.fill(last, -1);

        int j = n2-1;
        for(int i = n1-1; i>=0; i--){
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)){
                last[j] = i;
                j--;
            }
        }

        boolean skip = true;
        List<Integer> ans = new ArrayList<>();
        j = 0;
        for(int i = 0; i < n1; i++){
            if(j == n2) break;   
            if(word1.charAt(i) == word2.charAt(j)){
                ans.add(i);
                j++;
            }else{
                if(skip && (j == n2-1 || i < last[j+1])){
                    skip = false;
                    ans.add(i);
                    j++;
                }
            }
        }

        if(j == n2){
        int[] res = new int[ans.size()];
        int k = 0;
        for(int n : ans){
            res[k++] = n;
        }

        return res;
    }

    return new int[0];
    }
}