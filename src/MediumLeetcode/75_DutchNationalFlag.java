package MediumLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class DutchNationalFlag {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Sorted Array: " + Arrays.toString(sol1(array)));

        sc.close();
    }

    // TC: O(N)
    // SC: O(1)
    // 1. Use three pointers to divide the array into three sections:
    //    - trackZero: Position for placing 0s
    //    - trackCurrEl: Current element being checked
    //    - trackTwo: Position for placing 2s
    // 2. If current element is:
    //    - 0: Swap it with trackZero and move both pointers forward.
    //    - 1: Move current pointer as it is already in the correct position.
    //    - 2: Swap it with trackTwo and decrease trackTwo pointer.
    public static int[] sol1(int[] array) {

        int trackZero = 0;
        int trackCurrEl = 0;
        int trackTwo = array.length - 1;

        // Process elements until current pointer crosses the 2's section
        while (trackCurrEl <= trackTwo) {

            if (array[trackCurrEl] == 0) {
                // Place 0 at the beginning section
                int temp = array[trackZero];
                array[trackZero] = array[trackCurrEl];
                array[trackCurrEl] = temp;
                trackZero++;
                trackCurrEl++;
            } else if (array[trackCurrEl] == 1) {
                // 1 is already in the correct middle section
                trackCurrEl++;
            } else {
                // Place 2 at the end section
                int temp = array[trackCurrEl];
                array[trackCurrEl] = array[trackTwo];
                array[trackTwo] = temp;
                trackTwo--;
            }
        }

        return array;
    }

    // TC: O(N)
    // SC: O(1)
    // Approach:
    // 1. Count the frequency of 0s, 1s, and 2s in the array.
    // 2. Overwrite the array by placing:
    //    - All 0s first
    //    - Then all 1s
    //    - Then all 2s
    public static int[] sol2(int[] array) {

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        // Count occurrences of 0, 1, and 2
        for (int num : array) {
            if (num == 0) {
                zeros++;
            } else if (num == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        int index = 0;

        // Place all zeros
        while (zeros-- != 0) {
            array[index] = 0;
            index++;
        }

        // Place all ones
        while (ones-- != 0) {
            array[index] = 1;
            index++;
        }

        // Place all twos
        while (twos-- != 0) {
            array[index] = 2;
            index++;
        }

        return array;
    }
}