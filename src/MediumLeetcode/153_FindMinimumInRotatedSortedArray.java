package MediumLeetcode;

import java.util.Scanner;

class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int [] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Solution 1 Answer: " + sol1(array));
        System.out.println("Solution 2 Answer: " + sol2(array));
        System.out.println("Solution 3 Answer: " + sol3(array));
    }


    // Approach:
    // Traverse the entire array and keep track of the
    // smallest element seen so far.

    // Time Complexity : O(n)
    // Space Complexity: O(1)
    public static int sol1(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    // Approach:
    // Traverse the array while it remains sorted in increasing order.
    // The first smaller element after the break point is the minimum.
    // If no break point exists, the array was never rotated, so
    // the first element is the minimum.

    // Time Complexity : O(n)
    // Space Complexity: O(1)
    public static int sol2(int[] nums) {

        int i = 0;

        while (i + 1 < nums.length && nums[i + 1] > nums[i]) {
            i++;
        }

        return (i + 1 < nums.length) ? nums[i + 1] : nums[0];
    }

    // Solution 3 : Binary Search (Optimal)
    // Approach:
    // Compare nums[mid] with nums[right].
    // If (nums[mid] > nums[right]),
    // the minimum lies in the right half.
    // else
    // the minimum lies at mid or in the left half.
    // Continue until left == right.

    // Time Complexity : O(log n)
    // Space Complexity: O(1)
    public static int sol3(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
