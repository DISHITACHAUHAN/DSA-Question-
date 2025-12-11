public class Question5 {
    // Iterative method
    static long factorialIterative(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Recursive method
    static long factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Factorial (Iterative): " + factorialIterative(n));
        System.out.println("Factorial (Recursive): " + factorialRecursive(n));
    }
}
