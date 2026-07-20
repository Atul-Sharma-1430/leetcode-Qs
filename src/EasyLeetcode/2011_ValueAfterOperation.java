package EasyLeetcode;

import java.util.Scanner;

class ValueAfterOperation {

    public static int finalValueAfterOperations(String[] operations) {

        int ans = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                ans++;
            } else {
                ans--;
            }
        }

        return ans;
    }

    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        String[] operations = new String[n];

        System.out.println("Enter the operations:");
        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextLine();
        }

        int result = finalValueAfterOperations(operations);

        System.out.println("Final Value: " + result);

        sc.close();
    }
}