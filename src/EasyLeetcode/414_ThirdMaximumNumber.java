package EasyLeetcode;

import java.util.Scanner;

class ThirdMaximumNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Method 1 Answer : " + thirdMax1(nums));
        System.out.println("Method 2 Answer : " + thirdMax2(nums));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    public static int thirdMax1(int[] nums) {

        long largest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;
        long thirdLargest = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // Duplicate values ko pahle hi ignore kr do
            if (nums[i] == largest || nums[i] == secondLargest || nums[i] == thirdLargest) {
                continue;
            }

            if (nums[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = nums[i];
            } else if (nums[i] > thirdLargest) {
                thirdLargest = nums[i];
            }
        }

        // Agar third largest exist nhi krta to largest return maaro
        if (thirdLargest == Long.MIN_VALUE) {
            return (int) largest;
        }

        return (int) thirdLargest;
    }

    // TC : O(n)
    // SC : O(1)
    public static int thirdMax2(int[] nums) {

        long largest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;
        long thirdLargest = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                thirdLargest = secondLargest;
                secondLargest = nums[i];
            } else if (nums[i] > thirdLargest && nums[i] != secondLargest && nums[i] != largest) {
                thirdLargest = nums[i];
            }
        }

        // Agar third largest exist nhi krta to largest ko return kro do
        if (thirdLargest == Long.MIN_VALUE) {
            return (int) largest;
        }

        return (int) thirdLargest;
    }
}