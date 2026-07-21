package EasyLeetcode;

import java.util.Scanner;

class CountingBits {

    // TC: O(n)
    // SC: O(n)
    public static int[] countBits(int n) {

        int[] ansArray = new int[n + 1];

        for (int i = 1; i < ansArray.length; i++) {
            // Formula: ansArray[i] = ansArray[i / 2] + (i % 2)
            // Example: i = 75
            // Binary of 75 = 1001011
            // i / 2 = 37, Binary of 37 = 100101, ansArray[37] = 3
            // i % 2 = 1 (75 is odd)
            // Therefore, ansArray[75] = 3 + 1 = 4
            // (1001011 has 4 bits of 1)
            ansArray[i] = ansArray[i / 2] + (i % 2);
        }

        return ansArray;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] result = countBits(n);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}