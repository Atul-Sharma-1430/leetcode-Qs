package MediumLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class TwoSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " Elements in sorted order:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the Target value: ");
        int target  = sc.nextInt();

        Arrays.sort(array);
        System.out.println((Arrays.toString(twoSum2(array, target))));

        sc.close();
    }

    // TC : O(n)
    // SC : O(1)
    // Patter : Two Pointer
    public static int[] twoSum2(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while(left < right) {

            if (array[left] + array[right] == target) {
                return new int[] {left+1, right+1};
            }
            else if (array[left] + array[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}
