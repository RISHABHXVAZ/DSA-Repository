class Solution {
    int waviness(int n){
        List<Integer> digits = new ArrayList<>();
        while(n != 0){
            int x = n % 10;
            digits.add(x);
            n /= 10;
        }

        Collections.reverse(digits);

        int ans = 0;
        for(int i = 1; i < digits.size()-1; i++){
            if((digits.get(i) > digits.get(i-1) && digits.get(i) > digits.get(i+1)) || (digits.get(i-1) > digits.get(i) && digits.get(i) < digits.get(i+1))) ans++;
        }
        return ans;
    }
    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        for(int i = num1; i <= num2; i++){
            sum += waviness(i);
        }

        return sum;
    }
}