class Solution {
    public int maxProfit(int[] prices) {
        // O(n)    
        int N = prices.length - 1;
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (prices[i] > prices[N]) {
                int temp = prices[i];
                prices[N] = prices[i];
            }
            else {
                int sub = prices[N] - prices[i];

                if (sub > answer) {
                    answer = sub;
                }
            }
        }

        return answer;
    }
}
