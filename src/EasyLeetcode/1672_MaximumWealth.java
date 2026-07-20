package EasyLeetcode;

import java.util.Scanner;

class MaximumWealth {

    public static int maximumWealth(int[][] accounts) {

        int ans = 0;
        for (int[] account : accounts) {
            int currAmt = 0;

            for (int i : account) {
                currAmt += i;
            }

            if (currAmt > ans) {
                ans = currAmt;
            }
        }

        return ans;
    }

    // TC : O(n2)
    // SC : O(1)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of banks: ");
        int cols = sc.nextInt();

        int[][] accounts = new int[rows][cols];

        System.out.println("Enter the wealth of each customer:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                accounts[i][j] = sc.nextInt();
            }
        }

        int result = maximumWealth(accounts);

        System.out.println("Maximum Wealth: " + result);

        sc.close();
    }
}