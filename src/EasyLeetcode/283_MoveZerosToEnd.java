package EasyLeetcode;

import java.util.Scanner;

class MoveZerosToEnd {

    // TC = O(n), SC = O(1)
    public static void main(String... arguments) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();
        int [] array = new int[size];
        System.out.println("Enter " + size + " numbers one by one: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter number " + (i+1) + " :-");
            array[i] = sc.nextInt();
        }

        int first = 0, next = 1;
        while( next < array.length ){
            if (array[first] == 0 && array[next] != 0) {
                int temp = array[first];
                array[first] = array[next];
                array[next] = temp;
                next++;
                first++;
            } else if (array[first] == 0 && array[next] == 0 ) {
                next++;
            } else {
                first++;
                next++;
            }

        }
        System.out.print("Array after moving zeros to end: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        sc.close();
    }

    // Optimal
    // TC = O(n), SC = O(1)
    public void moveZeroes(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    //     public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter the size of the array: ");
    //     int size = sc.nextInt();
    //     int[] array = new int[size];

    //     System.out.println("Enter " + size + " numbers one by one:");
    //     for (int i = 0; i < size; i++) {
    //         array[i] = sc.nextInt();
    //     }
    //     System.out.print("Enter the number which is to be moved to last:");
    //     int target = sc.nextInt();

    //     int index = 0;
    //     for (int num : array) {
    //         if (num != target) {
    //             array[index++] = num;
    //         }
    //     }

    //     while (index < array.length) {
    //         array[index] = target;
    //         index++;
    //     }

    //     System.out.print("Array after moving " + target + " to end: ");
    //     for (int num : array) {
    //         System.out.print(num + " ");
    //     }

    //     sc.close();
    // }
}


