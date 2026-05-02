package EasyLeetcode;

import java.util.Scanner;
// TC = O(1), SC = O(1)
class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        int largestPow = (int) Math.pow(3, 19);

        return largestPow % n == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean result = isPowerOfThree(n);

        if (result) {
            System.out.println(n + " is a power of 3");
        } else {
            System.out.println(n + " is NOT a power of 3");
        }

        sc.close();
    }
}