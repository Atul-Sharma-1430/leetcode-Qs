class Fibonacci {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        int n = 10; 
        int result = solution.fib(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
