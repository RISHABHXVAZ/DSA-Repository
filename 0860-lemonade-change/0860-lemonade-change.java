class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0, ten = 0, twenty = 0;
        for(int i = 0; i < n; i++){
            if(bills[i] == 5) five++;
            else if(bills[i] == 10){
                ten++;
                if(five > 0) five--;
                else return false; 
            }
            else{
                twenty++;
                 if(five >= 1 && ten >= 1){
                    five--;
                    ten--;
                }
                else if(five >= 3) five -= 3;
                else return false;
            }
        }
        return true;
    }
}