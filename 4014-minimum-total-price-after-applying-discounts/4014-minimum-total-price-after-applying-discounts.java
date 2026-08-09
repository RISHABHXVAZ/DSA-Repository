class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        double sum = 0;
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            sum += prices[i] * (100.0 - discounts[j]) / 100.0;
            j--;
            i--;
        }

        while (i >= 0) {
            sum += prices[i];
            i--;
        }

        return sum;
    }
}