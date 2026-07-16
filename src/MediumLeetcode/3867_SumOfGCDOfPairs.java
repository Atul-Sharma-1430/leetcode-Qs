package MediumLeetcode;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfGCDOfPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int [] array = new int[size];
        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));

        sc.close();
    }

    public static int solution(int[] array) {
        int maxSoFar = -1;

        int [] prefixGCD = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            maxSoFar = Math.max(maxSoFar, array[i]);
            prefixGCD[i] = findGCD(maxSoFar, array[i]);
        }

        Arrays.sort(prefixGCD);

        int finalSum = 0;
        for (int i = 0; i < prefixGCD.length/2; i++) {
            finalSum += findGCD(prefixGCD[i], prefixGCD[prefixGCD.length - i -1]);
        }

        return finalSum;
    }

    public static int findGCD(int num1, int num2) {
        while(num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }
}
