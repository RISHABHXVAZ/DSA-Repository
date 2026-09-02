class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int last = -1;
        int l = 1;
        int maxlen = 1;

        for(int i = 0; i < n-1; i++){
            if(last == -1){
                l = 1;
                if(arr[i] > arr[i+1]){
                    last = 0;
                }else if(arr[i] < arr[i+1]){
                    last = 1;
                }else continue;
            }else if(last == 0){
                if(arr[i] < arr[i+1]){
                    l++;
                    last = 1;
                }else if(arr[i] > arr[i+1]){
                    last = 0;
                    l = 1;
                }else{
                    last = -1;
                }
            }else{
                if(arr[i] > arr[i+1]){
                    l++;
                    last = 0;
                }else if(arr[i] < arr[i+1]){
                    last = 1;
                    l = 1;
                }else last = -1;
            }

            maxlen = Math.max(maxlen, l+1);
        }

        return maxlen;
    }
}