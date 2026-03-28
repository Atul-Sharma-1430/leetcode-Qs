package EasyLeetcode;

import java.util.Arrays;
import java.util.Scanner;

class InsertPosition{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int [] array = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Enter the target element: ");
        int target = sc.nextInt();
        
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        InsertPosition Q = new InsertPosition();
        int result = Q.ansFunction(array , target);
        System.out.println("Target should be at index: " + result);
        sc.close();

    }
    
    int ansFunction( int [] array , int target) {
        if( target < array[0]) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
            if (i < array.length - 1 && array[i] < target && array[i + 1] > target) {
                return i + 1;
            }
        }
        return array.length;
    }
}
