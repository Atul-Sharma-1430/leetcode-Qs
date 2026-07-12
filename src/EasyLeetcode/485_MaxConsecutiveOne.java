package EasyLeetcode;

import java.util.Scanner;

class MaxConsecutiveOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int currLen = 0, maxLen = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 1) {
                currLen = 0;
            }

            if (nums[i] == 1) {
                currLen++;
            }

            if(currLen > maxLen) {
                maxLen = currLen;
            }
        }

        return maxLen;
    }

    // TC : O(n)
    // SC : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.println("Enter " + size + " elements (0 or 1):");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Maximum consecutive ones: " + result);

        sc.close();
    }
}