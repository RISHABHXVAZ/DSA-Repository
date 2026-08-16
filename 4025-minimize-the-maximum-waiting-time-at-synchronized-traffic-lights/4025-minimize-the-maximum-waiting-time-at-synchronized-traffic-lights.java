class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n1 = lights.length;
        int n2 = arrivalTime.length;

        int[] r = new int[n2];
        for(int i = 0; i < n2; i++){
            r[i] = arrivalTime[i]%period;
        }

        int penalty = Integer.MIN_VALUE;
        Arrays.sort(lights);
        for(int i = 0; i < n2; i++){
            int wt = Integer.MAX_VALUE;
            int low = 0, high = n1-1;
            while(low <= high){
                int mid = low + (high-low)/2;
                int light = lights[mid];

                if(light > r[i]){
                    wt = 0;
                    break;
                }else if(light <= r[i]){
                    wt = Math.min(wt, period-r[i]);
                    low = mid+1;
                }
            }

            penalty = Math.max(penalty, wt);
        }

        return penalty;
    }
}