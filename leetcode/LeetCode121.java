class Solution {
    // solution 1
    public int maxProfit1(int[] prices) {
        // O(n)    
        int N = prices.length - 1;
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (prices[i] > prices[N]) {
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

    // solution 2 -> 더 간략화화
    public int maxProfit2(int[] prices) {
            // O(n)    
            int N = prices.length - 1;
            int answer = 0;
            for (int i = N - 1; i >= 0; i--) {
                answer = Math.max(prices[N] - prices[i], answer);
                prices[N] = Math.max(prices[i], prices[N]);
            }
    
            return answer;
    }
}
