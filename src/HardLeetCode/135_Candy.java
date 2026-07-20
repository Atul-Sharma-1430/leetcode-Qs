package HardLeetCode;

import java.util.Arrays;
import java.util.Scanner;

class Candy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of children: ");
        int n = sc.nextInt();

        int[] rank = new int[n];

        System.out.println("Enter the ratings:");
        for (int i = 0; i < n; i++) {
            rank[i] = sc.nextInt();
        }

        int result = giveCandy(rank);

        System.out.println("Minimum candies required: " + result);

        sc.close();
    }

    // TC : O(n)
    // SC : O(n)
    public static int giveCandy(int[] rank) {

        int[] candies = new int[rank.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < rank.length; i++) {
            if (rank[i] > rank[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = rank.length - 2; i >= 0; i--) {
            if (rank[i] > rank[i + 1]) {
                if (candies[i] == candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                } else if (candies[i] < candies[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1]);
                }
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}