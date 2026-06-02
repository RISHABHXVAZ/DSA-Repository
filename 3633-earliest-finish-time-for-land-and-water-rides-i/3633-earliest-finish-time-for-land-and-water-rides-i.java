class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n1 = landStartTime.length;
        int n2 = waterStartTime.length;
       
       int ans1 = Integer.MAX_VALUE;
        for(int i = 0; i < n1; i++){
            int t = landStartTime[i] + landDuration[i];
            for(int j = 0; j < n2; j++){
                ans1 = Math.min(ans1,Math.max(t, waterStartTime[j]) + waterDuration[j]);
            }
        }

        int ans2 = Integer.MAX_VALUE;
        for(int i = 0; i < n2; i++){
            int t = waterStartTime[i] + waterDuration[i];
            for(int j = 0; j < n1; j++){
                ans2 = Math.min(ans2, Math.max(t, landStartTime[j]) + landDuration[j]);
            }
        }
        return (int)Math.min(ans1, ans2);
        
    }
}