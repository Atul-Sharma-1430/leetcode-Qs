package EasyLeetcode;
import java.util.Scanner;

class ArrangeCoins {
    // TC : O(root(n))
    // SC : O(1)
    public static int arrangeCoins(int n) {
        int count = 0;
        int i = 1;

        while (n >= i) {
            n -= i;
            count++;
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();

        int result = arrangeCoins(n);

        System.out.println("Maximum complete rows = " + result);

        sc.close();
    }
}