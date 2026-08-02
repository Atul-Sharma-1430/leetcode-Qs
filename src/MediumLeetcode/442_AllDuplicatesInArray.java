package MediumLeetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AllDuplicatesInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Duplicate Elements: " + findDuplicatesHashing(nums));
        System.out.println("Duplicate Elements: " + findDuplicatesOptimal(nums));

        sc.close();
    }

    // TC : O(n)
    // SC : O(n)
    public static List<Integer> findDuplicatesHashing(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int[] hashArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {

            hashArray[nums[i]]++;

            if (hashArray[nums[i]] == 2) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    // TC : O(n)
    // SC : O(1) (excluding the output list)
    public static List<Integer> findDuplicatesOptimal(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        // Har number ko uske corresponding index par map krenge.
        // Pehli baar mile to us index ki value negative mark kar denge.
        // Agar dobara wahi number mila aur us index ki value already negative hai,
        // to vo number duplicate hai.

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            // Agar index wali value already negative hai,
            // to current number duplicate hai.
            if (nums[index] < 0) {
                ans.add(index + 1);
            } else {
                // Pehli baar mila hai, toh negative mark kar do.
                nums[index] = -Math.abs(nums[index]);
            }
        }

        return ans;
    }
}
