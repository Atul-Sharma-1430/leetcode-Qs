package EasyLeetcode;

import java.util.Scanner;

class PickGifts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of gift piles: ");
        int n = sc.nextInt();

        int[] gifts = new int[n];

        System.out.println("Enter the number of gifts in each pile:");
        for (int i = 0; i < n; i++) {
            gifts[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Remaining Gifts: " + pickGiftsBetter(gifts, k));

        sc.close();
    }

    // TC : O(k * n)
    // SC : O(1)
    public static long pickGiftsBetter(int[] gifts, int k) {

        // Repeat the operation k times.
        for (int i = 1; i <= k; i++) {

            // Assume the first pile has the maximum gifts.
            int largest = gifts[0];
            int index = 0;

            // Find the largest pile and its index.
            for (int j = 1; j < gifts.length; j++) {
                if (gifts[j] > largest) {
                    largest = gifts[j];
                    index = j;
                }
            }

            // Replace the largest pile with floor(sqrt(largest)).
            gifts[index] = (int) Math.sqrt(largest);
        }

        // Find the sum of all remaining gifts.
        long sum = 0;

        for (int i = 0; i < gifts.length; i++) {
            sum += gifts[i];
        }

        return sum;
    }
}