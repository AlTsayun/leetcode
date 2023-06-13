public class BestTimeToBuyAndSellStock2_122 {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                var dayProfit = prices[i] - prices[i - 1];
                if (dayProfit > 0) {
                    profit += dayProfit;
                }
            }
            return profit;
        }
    }
}
