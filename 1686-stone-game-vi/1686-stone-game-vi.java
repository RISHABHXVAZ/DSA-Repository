class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0]+b[1], a[0]+a[1]));
        for(int i = 0; i < n; i++){
            int a = aliceValues[i];
            int b = bobValues[i];
            pq.add(new int[]{a,b});
        }

        int res = 0;
        int turn = 1;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            if(turn == 1){
                res += p[0];
                turn = 0;
            }else{
                res -= p[1];
                turn = 1;
            }
        }

        if(res == 0) return 0;
        return res > 0 ? 1 : -1;
    }
}