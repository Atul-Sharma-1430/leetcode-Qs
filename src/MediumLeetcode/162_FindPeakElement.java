package MediumLeetcode;

import java.util.Scanner;

class FindPeakElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int bruteAns = findPeakBrute(nums);
        System.out.println("Brute Force Peak Index = " + bruteAns);
        System.out.println("Brute Force Peak Value = " + nums[bruteAns]);

        System.out.println();

        int optimalAns = findPeakOptimal(nums);
        System.out.println("Optimal Peak Index = " + optimalAns);
        System.out.println("Optimal Peak Value = " + nums[optimalAns]);
    }


    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public static int findPeakBrute(int[] nums) {
        // Agar sirf ek element hai to wahi peak hai
        if (nums.length == 1) {
            return 0;
        }

        // Pure array ko traverse karo
        for (int i = 0; i < nums.length; i++) {
            // First element check karo
            if (i == 0) {
                // Agar next element se bada hai
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }

            // Last element check karo
            else if (i == nums.length - 1) {
                // Agar previous element se bada hai
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            }

            // Middle elements check
            else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }

        return -1;
    }

    // Optimal Binary Search
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    public static int findPeakOptimal(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Mid calculate karo
            int mid = left + (right - left) / 2;

            // Agar right neighbour bada hai
            // To peak right side me hoga
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            }

            // Agar left neighbour bada hai
            // To peak left side me hoga
            else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        // Left aur Right same index pe aa jayenge
        return left;
    }
}