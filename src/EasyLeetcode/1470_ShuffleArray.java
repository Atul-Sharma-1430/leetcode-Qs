package EasyLeetcode;

import java.util.Scanner;

class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];

        int i = 0;
        int j = n;
        int index = 0;

        while (i < n) {
            ans[index++] = nums[i];
            ans[index++] = nums[j];
            i++;
            j++;
        }

        return ans;
    }

    // TC : O(n/2)
    // SC : O(n)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int[] nums = new int[2 * n];

        System.out.println("Enter " + (2 * n) + " elements:");

        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = shuffle(nums, n);

        System.out.println("Shuffled Array:");

        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}