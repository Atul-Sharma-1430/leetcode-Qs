package EasyLeetcode;

class EvenOddSumGCD {
    public static int findGCD(int num1, int num2) {
        int gcd = 0;

        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    // TC : O(n2)
    // SC : O(1)
    public static int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= 2 * n; i += 2) {
            oddSum += i;
            evenSum += (i + 1);
        }

        return findGCD(oddSum, evenSum);
    }

    // TC : O(max(oddSum , evenSum)
    // SC : O(1)
    public static int gcdOfOddEvenSums2(int n) {

        int oddSum = n * n;
        int totalSum = (2 * n * (2 * n + 1)) / 2;
        int evenSum = totalSum - oddSum;

        return findGCD(oddSum, evenSum);
    }

    // Mathematical observation:
    // Sum of first n odd numbers = n²
    // Sum of first n even numbers = n(n+1)
    // GCD(n², n(n+1)) = n * GCD(n, n+1)
    // Since consecutive numbers are always coprime, GCD(n, n+1) = 1
    // Therefore, the answer is always n.
    public static int gcdOfOddEvenSums3(int n) {
        return n;
    }

    public static void main(String[] args) {
        int n = 5;

        int result = gcdOfOddEvenSums(n);

        System.out.println("GCD of odd and even sums: " + result);
    }
}
