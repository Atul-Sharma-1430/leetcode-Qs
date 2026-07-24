package MediumLeetcode;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

class LongestConsecutiveSeq {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Better      : " + lcsBetter(array));
        System.out.println("Optimal     : " + lcsOptimal(array));

        sc.close();
    }

    // Brute Force
    // TC : O(n²)
    // SC : O(1)
    public static int lcsBrute(int[] nums) {

        // Final answer store karega
        int longest = 0;

        // Har element ko starting point maan ke check karenge
        for (int i = 0; i < nums.length; i++) {

            // Current element
            int current = nums[i];

            // Current sequence ki length
            int count = 1;

            // Jab tak next consecutive element milta rahe
            // Example : 1 -> 2 -> 3 -> 4
            while (linearSearch(nums, current + 1)) {
                current++;
                count++;
            }

            // Maximum sequence length update karo
            longest = Math.max(longest, count);
        }

        return longest;
    }

    // Linear search se target find karte hai
    public static boolean linearSearch(int[] nums, int target) {

        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    // Better Approach (Sorting)
    // TC : O(n log n)
    // SC : O(1)
    public static int lcsBetter(int[] nums) {

        Arrays.sort(nums);

        // Final answer
        int longest = 0;

        // Previous unique element store karega
        int lastSmallest = Integer.MIN_VALUE;

        // Current sequence ki length
        int count = 0;

        // Sorted array traverse karo
        for (int i = 0; i < nums.length; i++) {

            // Duplicate element mila to ignore karo
            if (nums[i] == lastSmallest) {
                continue;
            }

            // Agar current element previous se sirf 1 bada hai
            // To sequence continue ho rahi hai
            else if (nums[i] == lastSmallest + 1) {
                count++;
                lastSmallest = nums[i];
            }

            // Naya sequence start hoga
            else {
                count = 1;
                lastSmallest = nums[i];
            }

            // Maximum sequence length update karo
            longest = Math.max(longest, count);
        }

        return longest;
    }

    // Optimal Approach (HashSet)
    // TC : O(n)
    // SC : O(n)
    public static int lcsOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // Sare unique elements HashSet me daal do
        for (int num : nums) {
            set.add(num);
        }

        // Final answer store karega
        int maxLen = 0;

        // Set traverse karenge kyuki duplicates automatically remove ho jate hai
        for (int num : set) {

            // Sirf wahi element sequence ka start ho sakta hai
            // Jiska previous element exist na karta ho
            if (!set.contains(num - 1)) {

                // Current sequence ki length
                int count = 1;

                // Next consecutive elements check karne ke liye
                int j = 1;

                // Jab tak next element milta rahe tab tk loop chalega
                while (set.contains(num + j)) {
                    j++;
                    count++;
                }

                // Maximum length update karo
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}