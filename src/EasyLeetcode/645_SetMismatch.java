package EasyLeetcode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

class SetMismatch {
    // TC : O(n)
    // SC : O(n)
    public static int[] findErrorNumsBetter(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[2];

        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                ans[0] = i;
            } else if (!map.containsKey(i)) {
                ans[1] = i;
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

        int[] ans = findErrorNumsBetter(nums);

        System.out.println("\nResult: " + Arrays.toString(ans));
        System.out.println("Duplicate Number: " + ans[0]);
        System.out.println("Missing Number: " + ans[1]);

        sc.close();
    }
}
