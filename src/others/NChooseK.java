package others;

public class NChooseK {

    public static void main(String[] args) {
        System.out.println("Find the number of ways of forming a team of 5 members out of 10 members.");
        System.out.println(getCombinations(10, 5));
    }

    private static int getCombinations(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    private static int factorial(int n) {
        int acc = 1;
        for (int i = 2; i < n; i++) {
            acc *= i;
        }
        return acc;
    }
}
