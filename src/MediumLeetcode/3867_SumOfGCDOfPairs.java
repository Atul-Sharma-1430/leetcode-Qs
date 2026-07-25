package MediumLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class SumOfGCDOfPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));

        sc.close();
    }


    // TC: O(N log N)
    // SC: O(N)

    public static int solution(int[] array) {

        int maxSoFar = -1;

        // Stores GCD values generated from the prefix maximums
        int[] prefixGCD = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            // Keep track of maximum value encountered so far
            maxSoFar = Math.max(maxSoFar, array[i]);

            // Calculate GCD between current maximum and current element
            prefixGCD[i] = findGCD(maxSoFar, array[i]);
        }

        // Sort GCD values to create pairs
        Arrays.sort(prefixGCD);

        int finalSum = 0;

        // Pair smallest and largest values and add their GCD
        for (int i = 0; i < prefixGCD.length / 2; i++) {
            finalSum += findGCD(prefixGCD[i], prefixGCD[prefixGCD.length - i - 1]);
        }

        return finalSum;
    }

    // Calculates GCD using Euclidean Algorithm
    public static int findGCD(int num1, int num2) {

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }
}