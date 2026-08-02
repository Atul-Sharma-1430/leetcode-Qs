package EasyLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DisappearedNumInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findDisappearedNumHashing(nums));
        System.out.println(findDisappearedNumOptimal(nums));

        sc.close();
    }

    // TC : O(n)
    // SC : O(n)
    public static List<Integer> findDisappearedNumHashing(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        boolean[] boolHash = new boolean[nums.length];

        // Mark all numbers present in the array.
        for (int i = 0; i < nums.length; i++) {
            boolHash[nums[i] - 1] = true;
        }

        // Indices that remain false correspond to missing numbers.
        for (int i = 0; i < nums.length; i++) {
            if (!boolHash[i]) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // TC : O(n)
    // SC : O(1) (excluding the output list)
    public static List<Integer> findDisappearedNumOptimal(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        // Har number ko uske corresponding index par mark (negative) kar do.
        for (int i = 0; i < nums.length; i++) {

            // Current number ka corresponding index
            int index = Math.abs(nums[i]) - 1;

            // Agar pehle se mark nahi hua hai to negative kar do.
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        // Jo index positive reh gaye, unka matlab
        // vo number array me present hi nahi tha.
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
