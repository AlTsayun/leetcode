public class xxxLongestString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 0, 0));
        System.out.println(solution.solution(10, 10, 0));
        System.out.println(solution.solution(0, 10, 0));
        System.out.println(solution.solution(0, 10, 10));
        System.out.println(solution.solution(0, 10, 0));
        System.out.println(solution.solution(0, 0, 10));
        System.out.println(solution.solution(10, 0, 10));

        System.out.println(solution.solution(1, 1, 1));
        System.out.println(solution.solution(0, 0, 1));
        System.out.println(solution.solution(0, 1, 0));
        System.out.println(solution.solution(1, 0, 0));
        System.out.println(solution.solution(0, 1, 1));
        System.out.println(solution.solution(1, 0, 1));
        System.out.println(solution.solution(1, 1, 0));
        System.out.println(solution.solution(0, 0, 0));
        System.out.println(solution.solution(1, 1, 2));
        System.out.println(solution.solution(3, 1, 1));

    }

    static class Solution {

        public String solution(int AA, int AB, int BB) {
            StringBuilder sb = new StringBuilder();
            sb.append(AA);
            sb.append(" ");
            sb.append(AB);
            sb.append(" ");
            sb.append(BB);
            sb.append(": ");

            if (BB > AA) {
                sb.append("BB");
                BB--;
            }

            while (AB > 0) {
                sb.append("AB");
                AB--;
            }

            while (BB > 0 && AA > 0) {
                sb.append("AABB");
                AA--;
                BB--;
            }

            if (AA > 0) {
                sb.append("AA");
            }

            return sb.toString();
        }

    }
}
