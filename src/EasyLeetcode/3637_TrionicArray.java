package EasyLeetcode;

import java.util.Scanner;

class TrionicArray {
    // TC : O(n)
    // SC : O(1)
    public static boolean isTrionic(int[] nums) {
        // Condition :- o < p < q < n-1

        int p = 0;
        // First increasing part
        while (p + 1 < nums.length && nums[p + 1] > nums[p]) {
            p++;
        }
        // if no increasing part then condition not satisfied hence false;
        if (p == 0) {
            return false;
        }


        int q = p;
        // Second decreasing part
        while (q + 1 < nums.length && nums[q + 1] < nums[q]) {
            q++;
        }
        //  if no decreasing part then condition not satisfied hence false;
        if (p == q) {
            return false;
        }


        int last = q;
        // Third increasing part
        while (last + 1 < nums.length && nums[last + 1] > nums[last]) {
            last++;
        }
        //  if no increasing part again then condition not satisfied hence false
        if (last == q) {
            return false;
        }

        // whole array should be covered
        return last == nums.length - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (isTrionic(nums)) {
            System.out.println("The array is Trionic.");
        } else {
            System.out.println("The array is NOT Trionic.");
        }

        sc.close();
    }
}