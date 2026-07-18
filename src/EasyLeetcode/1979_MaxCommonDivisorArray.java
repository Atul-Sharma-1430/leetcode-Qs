package EasyLeetcode;

import java.util.Scanner;

class MaxCommonDivisorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int [] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(findGCD(array));

        sc.close();
    }

    // TC : O(k)
    public static int getGCD(int num1, int num2) {
        while(num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }

    // TC : O(n+k)
    // SC : O(1)
    public static int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int greatest = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > greatest) {
                greatest = nums[i];
            }

            if(nums[i] < smallest) {
                smallest = nums[i];
            }
        }

        return getGCD(smallest, greatest);
    }

}
