package EasyLeetcode;
import java.util.Scanner;

class NumbersWithEvenNumberOfDigits {

    // TC: O(n * d)
    // SC: O(1)
    public static int findNumbers(int[] nums) {

        int totalCount = 0;
        for(int i=0; i<nums.length; i++) {

            int lenCount = 0;
            while(nums[i] != 0) {
                lenCount++;
                nums[i] /= 10;
            }

            if(lenCount % 2 == 0) {
                totalCount++;
            }
        }

        return totalCount;
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

        int result = findNumbers(nums);

        System.out.println("Count of numbers with even number of digits: " + result);

        sc.close();
    }
}