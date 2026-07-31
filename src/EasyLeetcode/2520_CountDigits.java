package EasyLeetcode;

import java.util.Scanner;

class CountDigits {
    // TC: O(d), where d = number of digits in num
    // SC: O(1)
    public static int countDigits(int num) {

        int count = 0;
        int temp = num;

        while (temp != 0) {
            int rem = temp % 10;

            // if 0 then no divide
            if (rem != 0) {
                if (num % rem == 0) {
                    count++;
                }
            }

            temp /= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Count of digits that divide the number = " + countDigits(num));

        sc.close();
    }
}