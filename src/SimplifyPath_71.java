import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class SimplifyPath_71 {
    private static class Solution {
        public String simplifyPath(String path) {
            var deque = new ArrayDeque<String>();
            var split = path.split("/");

            for (String s : split) {
                if (s.equals("..")) {
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                    continue;
                }
                if (s.equals(".") || s.isEmpty()) {
                    continue;
                }
                deque.addLast(s);
            }
            return deque.stream().collect(Collectors.joining("/", "/", ""));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
    }
}
