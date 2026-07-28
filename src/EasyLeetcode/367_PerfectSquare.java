package EasyLeetcode;
import java.util.Scanner;

class PerfectSquare {
    // TC O(n log n)
    // SC : O(1)
    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sq = mid * mid;

            if (sq == num) {
                return true;
            } else if (sq < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean result = isPerfectSquare(num);

        if (result) {
            System.out.println(num + " is a perfect square");
        } else {
            System.out.println(num + " is not a perfect square");
        }

        sc.close();
    }
}