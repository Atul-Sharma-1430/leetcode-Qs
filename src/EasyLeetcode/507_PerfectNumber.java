package EasyLeetcode;
import java.util.Scanner;

// TC = O(n/2), SC = O(1)
class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to check for perfect number: ");
        int num = sc.nextInt();
        isPerfectNum(num);
        sc.close();
    }

    static void isPerfectNum(int num) {
        int sumOfFactors = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sumOfFactors += i;
            }
        }

        if (sumOfFactors == num) {
            System.out.println(num + " is a Perfect Number.");
        } else {
            System.out.println(num + " is not a Perfect Number.");
        }
    }
}
