public class BestTimeToBuyAndSellStockSolution_121 {
    private static class Solution {
        public int maxProfit(int[] prices) {
            int localMaxProfit;
            int maxProfit = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                localMaxProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, localMaxProfit);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return maxProfit;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 1, 8}));
        System.out.println(new Solution().maxProfit(new int[]{4, 3, 2, 1}));
        System.out.println(new Solution().maxProfit(new int[]{15}));
        System.out.println(new Solution().maxProfit(new int[]{0}));
    }
}