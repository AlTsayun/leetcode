public class MinCostClimbingStairs_746 {
    private static class Solution {

        private int[] cost;
        private int[] minCost;

        public int minCostClimbingStairs(int[] cost) {
            this.cost = cost;
            this.minCost = new int[cost.length];
            return Math.min(minCost(cost.length - 1), minCost(cost.length - 2));
        }

        private int minCost(int destination) {
            if (destination == 0 || destination == 1) {
                return cost[destination];
            }

            return cost[destination] + Math.min(minCost(destination - 1), minCost(destination - 2));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
