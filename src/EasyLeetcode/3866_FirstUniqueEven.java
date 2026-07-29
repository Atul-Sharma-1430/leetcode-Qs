package EasyLeetcode;

import java.util.HashMap;
import java.util.Scanner;

class FirstUniqueEven {
    // TC: O(n²)
    // SC: O(1)
    public static int method1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            // Odd numbers ko skip kar do
            if (nums[i] % 2 != 0) {
                continue;
            }

            boolean isSingle = true;
            // Check karo ki current even number aur kahin present hai ya nahi
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    isSingle = false;
                    break;
                }
            }

            // Agar unique even number mil gaya
            if (isSingle) {
                return nums[i];
            }
        }

        return -1;
    }

    // TC: O(n)
    // SC: O(n)
    public static int method2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Sirf even numbers ki frequency count karo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        // First unique even number return karo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && map.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        return -1;
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

        System.out.println("Method 1 (Brute Force): " + method1(nums));
        System.out.println("Method 2 (HashMap): " + method2(nums));

        sc.close();
    }
}