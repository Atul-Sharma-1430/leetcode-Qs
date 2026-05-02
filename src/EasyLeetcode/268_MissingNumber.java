package EasyLeetcode;

import java.util.Scanner;

class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();

        int [] array = new int[n];
        System.out.println("Enter Numbers from 0 to " + n + " by leaving any one number in between: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("The Missing Number in the Array is " + findMissingNumber(array));
    }

    // TC = O(n), SC = O(1)
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n*(n+1))/2;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return totalSum - sum;
    }
}
