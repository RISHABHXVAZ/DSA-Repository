class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int sl = 0, sr = 0, cl = 0, cr = 0;

        for(int i = 0; i < n/2; i++){
            char ch = num.charAt(i);
            if(ch == '?') cl++;
            else sl += Integer.parseInt(ch+"");
        }

        for(int i = n/2; i < n; i++){
            char ch = num.charAt(i);
            if(ch == '?') cr++;
            else sr += Integer.parseInt(ch+"");
        }

        int dels = sl-sr, delc = cl-cr;
        if(delc % 2 != 0) return true;
        int val = dels + (delc/2)*9;
        return !(val == 0);

    }
}