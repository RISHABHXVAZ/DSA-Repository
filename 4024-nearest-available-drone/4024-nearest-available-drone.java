class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
      int n = drones.length;
    
      int tx = target[0], ty = target[1];

      int mindist = Integer.MAX_VALUE, minidx = -1;
      for(int i = 0; i < n; i++){
        int dx = drones[i][0];
        int dy = drones[i][1];
        int range = drones[i][2];

        int dist = Math.abs(tx-dx) + Math.abs(ty-dy);
        if(dist <= range && mindist > dist){
            mindist = dist;
            minidx = i;
        }
      }

      return minidx;   
    }
}