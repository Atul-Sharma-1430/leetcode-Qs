package MediumLeetcode;

import java.util.Scanner;

class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        nextPermutation(array);

        System.out.println("Next Permutation:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static void nextPermutation(int[] array) {
        int breakpoint = -1;

        // Find the first index from the right where array[i] < array[i + 1]
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        // If no breakpoint exists, the array is the last permutation.
        // Reverse it to obtain the first permutation.
        if (breakpoint == -1) {
            reverse(array, 0, array.length - 1);
            return;
        }

        // Find the first element from the right that is greater than
        // the breakpoint element and swap them.
        for (int i = array.length - 1; i > breakpoint; i--) {
            if (array[i] > array[breakpoint]) {
                int temp = array[i];
                array[i] = array[breakpoint];
                array[breakpoint] = temp;
                break;
            }
        }

        // Reverse the suffix to get the smallest possible arrangement.
        reverse(array, breakpoint + 1, array.length - 1);
    }

    // Helper method to reverse a part of the array
    public static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}