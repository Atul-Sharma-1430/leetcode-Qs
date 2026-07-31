package EasyLeetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MostFrequentEven {
    // TC: O(n)
    // SC: O(n)
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of even numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        // No even number present
        if (map.isEmpty()) {
            return -1;
        }

        int ans = Integer.MIN_VALUE;
        int count = -1;

        // Find most frequent even number
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > count) {
                ans = entry.getKey();
                count = entry.getValue();

            } else if (entry.getValue() == count) {
                // If frequency is same, choose smaller number
                ans = Math.min(entry.getKey(), ans);
            }
        }

        return ans;
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

        System.out.println("Most Frequent Even Number: " +  mostFrequentEven(nums));

        sc.close();
    }
}
