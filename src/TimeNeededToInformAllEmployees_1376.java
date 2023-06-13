import java.util.*;

public class TimeNeededToInformAllEmployees_1376 {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println(new Solution().numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
        System.out.println(new Solution().numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    private static class Solution {
        Map<Integer, List<Integer>> graph;
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                var list = graph.getOrDefault(manager[i], new ArrayList<>());
                list.add(i);
                graph.put(manager[i], list);
            }
            return dfs(headID, informTime);
        }

        private int dfs(int headID, int[] informTime) {
            if (!graph.containsKey(headID)) {
                return 0;
            }
            int time = 0;
            var subordinates = (List<Integer>) graph.get(headID);
            for (int subordinate : subordinates) {
                time = Math.max(time, dfs(subordinate, informTime));
            }
            return time + informTime[headID];
        }
    }

        private static class SlowSolution {
        public int[] dp;
        private int[] manager;
        private int[] informTime;
        private int n;

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            this.manager = manager;
            this.informTime = informTime;
            this.n = n;
            this.dp = new int[n];
            Arrays.fill(dp, -1);
            return numOfMinutes(headID);
        }

        private int numOfMinutes(int managerID) {
            if (dp[managerID] != -1) {
                return dp[managerID];
            }
            int totalTime = 0;
            for (int i = 0; i < n; i++) {
                if (manager[i] == managerID) {
                    totalTime = Math.max(totalTime, numOfMinutes(i));
                }
            }
            totalTime += informTime[managerID];
            dp[managerID] = totalTime;
            return totalTime;
        }
    }
}
