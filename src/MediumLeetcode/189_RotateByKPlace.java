package MediumLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class RotateByKPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Rotated Array: " + Arrays.toString(rotate(array, k)));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotate(int[] nums, int k) {
        k = k % nums.length;
        k = (nums.length - k) % nums.length;

        reverse(nums , 0 , k-1);
        reverse(nums, k , nums.length-1);
        reverse(nums, 0, nums.length-1);

        return nums;
    }
}
