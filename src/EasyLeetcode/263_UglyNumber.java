package EasyLeetcode;

import java.util.Scanner;

class UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (isUgly(num)) {
            System.out.println(num + " is an Ugly Number");
        } else {
            System.out.println(num + " is not an Ugly Number");
        }

        sc.close();
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }
}
