package EasyLeetcode;
import java.util.*;

// TC = O(n), SC = O(1)
class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int prev = 0;
        int next = 1;

        int k = 1;

        while (next < nums.length) {
            if (nums[next] != nums[prev]) {
                prev++;
                nums[prev] = nums[next];
                k++;
            }
            next++;
        }

        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = removeDuplicates(nums);

        // Output result
        System.out.println("Number of unique elements: " + k);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}