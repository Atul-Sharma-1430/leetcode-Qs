package EasyLeetcode;

import java.util.Scanner;

class LeftAndRightDifference {
    // TC: O(n)
    // SC: O(n)
    public static int[] leftRightDifference(int[] nums) {

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;

        // Calculate left prefix sums
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Calculate right suffix sums
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Store absolute difference in leftSum array
        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return leftSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = leftRightDifference(nums);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}