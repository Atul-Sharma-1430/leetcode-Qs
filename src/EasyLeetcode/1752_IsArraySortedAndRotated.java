package EasyLeetcode;

import java.util.Scanner;

class IsArraySortedAndRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.println("Enter " + size + " Elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        if (check(array) == 0) {
            System.out.println("Array is already Sorted");
        } else if(check(array) == 1) {
            System.out.println("Yes the Array is rotated and sorted");
        } else {
            System.out.println("Array is Rotated but not sorted");
        }

        sc.close();
    }

    public static int check(int[] nums) {

        int brkCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[(i + 1) % nums.length] < nums[i]) {
                brkCount++;
            }
        }

        if (brkCount == 0) return 0;
        if (brkCount == 1) return 1;
        return -1;
    }
}
