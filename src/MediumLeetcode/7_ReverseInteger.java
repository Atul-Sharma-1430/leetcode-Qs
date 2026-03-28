package MediumLeetcode;

import java.util.Scanner;
class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:");
        long result = reverse(sc.nextLong());
        System.out.println(result);

        sc.close();
    }

    public static long reverse(long x) {
        long rev = 0;
        while (x != 0) {
            long last = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && last > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && last < -8)) {
                return 0;
            }
            rev = rev * 10 + last;
            x /= 10;
        }
        return rev;
    }
}


