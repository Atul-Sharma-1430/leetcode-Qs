package EasyLeetcode;

import java.util.Scanner;
class PallindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        PallindromeNumber obj = new PallindromeNumber();
        boolean result = obj.isPalindrome(x);

        if (result) {
            System.out.println(x + " is a palindrome.");
        } else {
            System.out.println(x + " is not a palindrome.");
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x, reverse = 0;

        while (temp != 0) {
            int last = temp % 10;
            reverse = reverse * 10 + last;
            temp /= 10;
        }

        return x == reverse;
    }
}
