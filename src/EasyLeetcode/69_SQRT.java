package EasyLeetcode;
import java.util.Scanner;

// TC = O(log n), SC = O(1)
class SQRT {
    public int mySqrt(int x) {

        if (x == 0) return 0;

        long start = 1, end = x, ans = 1;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid <= x / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to find its square root: ");
        int number = sc.nextInt();

        SQRT solution = new SQRT();
        int sqrt = solution.mySqrt(number);

        System.out.println("Integer square root of " + number + " is: " + sqrt);

        sc.close();
    }
}
