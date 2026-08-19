class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a,b) -> a[0]-b[0]);

        int rows = 1;
        boolean start = false;
        int count = 0;
        boolean[] block = new boolean[3];
        Arrays.fill(block, true);
        int i = 0;
        while(i < reservedSeats.length){
            if(!start) {
                block = new boolean[3];
                Arrays.fill(block, true);
            }
            if(!start || reservedSeats[i][0] == reservedSeats[i-1][0]){
                start = true;
                int r = reservedSeats[i][1];
                if(r >= 2 && r <= 3) block[0] = false;
                if(r >= 4 && r <= 5){
                    block[0] = block[1] = false;
                }
                if(r >= 6 && r <= 7){
                    block[1] = block[2] = false;
                }
                if(r >= 8 && r <= 9) block[2] = false;
                i++;
            }else{
                rows++;
                start = false;
                if(block[0]){
                    if(block[2]) count += 2;
                    else count += 1;
                }else{
                    if(block[1]) count += 1;
                    else if(block[2]) count += 1;
                }
            }

        }
        if(block[0]){
                    if(block[2]) count += 2;
                    else count += 1;
                }else{
                    if(block[1]) count += 1;
                    else if(block[2]) count += 1;
                }

        count += (n-rows)*2;
        return count;
    }
}