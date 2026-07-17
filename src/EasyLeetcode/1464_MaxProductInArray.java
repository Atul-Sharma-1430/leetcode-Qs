package EasyLeetcode;

import java.util.Scanner;

class MaxProductInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int [] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(findMaxProd(array));

        sc.close();
    }

    public static int findMaxProd(int[] array) {
        // If the length is two then max product will be of that two only
        if (array.length == 2) {
            return (array[0] - 1) * (array[1] - 1);
        }

        // In an array the max product will be the product of largest and secondLargest number.
        int largest = Integer.MIN_VALUE;
        int secLargest = -1;

        for (int j : array) {
            if (j >= largest) {
                secLargest = largest;
                largest = j;
            } else if (secLargest < j) {
                secLargest = j;
            }
        }

        return (largest - 1) * ( secLargest - 1);

    }
}
