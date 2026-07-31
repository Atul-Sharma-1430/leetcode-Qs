package EasyLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PascalsTriangleII {
    // Approach 1 : Using nCr
    // TC: O(row²)
    // SC: O(row)
    public static List<Integer> printRow(int row) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= row; i++) {
            ans.add(nCr(row, i));
        }

        return ans;
    }

    // TC: O(r)
    // SC: O(1)
    public static int nCr(int n, int r) {

        if (r == 0 || r == n) {
            return 1;
        }

        if (r > n - r) {
            r = n - r;
        }

        long ans = 1;

        for (int i = 0; i < r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }

        return (int) ans;
    }

    // Approach 2 : Optimal (Using Previous Element)
    // TC: O(row)
    // SC: O(row)
    private static List<Integer> printRowOptimal(int row) {
        List<Integer> ans = new ArrayList<>();

        ans.add(1);

        long prev = 1;
        for (int i = 1; i <= row; i++) {
            prev = prev * (row - i + 1) / i;
            ans.add((int) prev);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row index (0-based): ");
        int row = sc.nextInt();

        System.out.println("\nUsing nCr Approach:");
        System.out.println(printRow(row));

        System.out.println("\nUsing Optimal Approach:");
        System.out.println(printRowOptimal(row));

        sc.close();
    }
}