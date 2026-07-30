package EasyLeetcode;
import java.util.Scanner;

class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println(checkPerfectNumberBrute(num));
        System.out.println(checkPerfectNumberOptimal(num));

        sc.close();
    }

    // TC: O(root(n))
    // SC: O(1)
    public static boolean checkPerfectNumberOptimal(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;

                int q = num / i;
                // Avoid adding the same divisor twice for perfect squares
                if (i != q) {
                    sum += q;
                }
            }
        }

        return sum == num;
    }

    // TC = O(n/2),
    // SC = O(1)
    public static boolean checkPerfectNumberBrute(int num) {
        int sumOfFactors = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sumOfFactors += i;
            }
        }

        return sumOfFactors == num;
    }
}
