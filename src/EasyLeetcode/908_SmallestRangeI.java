package EasyLeetcode;

import java.util.Scanner;

class SmallestRangeI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Minimum Score: " + smallestRangeI(nums, k));

        sc.close();
    }

    public static int smallestRangeI(int[] nums, int k) {

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                largest = nums[i];
            }

            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }

        // Agar range negative ho gaya to score 0 hoga
        if ((largest - k) - (smallest + k) < 0) {
            return 0;
        }

        return (largest - k) - (smallest + k);
    }
}