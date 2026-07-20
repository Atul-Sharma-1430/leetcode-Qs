package EasyLeetcode;

import java.util.Scanner;

class LargestAltitude {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of gains: ");
        int n = sc.nextInt();

        int[] gain = new int[n];

        System.out.println("Enter the gain values:");
        for (int i = 0; i < n; i++) {
            gain[i] = sc.nextInt();
        }

        System.out.println("\nMethod 1 Answer: " + largestAltitudeMethod1(gain));
        System.out.println("Method 2 Answer: " + largestAltitudeMethod2(gain));

        sc.close();
    }

    // Method 1: Using an altitude array
    // SC : O(n)
    // TC : O(n)
    public static int largestAltitudeMethod1(int[] gain) {

        int[] alt = new int[gain.length + 1];

        alt[0] = 0;
        int maxHeight = 0;

        for (int i = 1; i <= gain.length; i++) {
            alt[i] = alt[i - 1] + gain[i - 1];

            if (alt[i] > maxHeight) {
                maxHeight = alt[i];
            }
        }

        return maxHeight;
    }

    // Method 2: No extra array
    // SC : O(n)
    // TC : O(1)
    public static int largestAltitudeMethod2(int[] gain) {

        int sum = 0;
        int maxHeight = 0;

        for (int j : gain) {
            sum += j;

            if (sum > maxHeight) {
                maxHeight = sum;
            }
        }

        return maxHeight;
    }
}