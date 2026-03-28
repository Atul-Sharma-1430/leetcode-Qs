package MediumLeetcode;

import java.util.ArrayList;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int [] array = new int[size];
        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        ThreeSum Sum3 = new ThreeSum();

        List<int[]> result = Sum3.threeSumFunction(array);
        if(result.isEmpty()) {
            System.out.print("There is no such triplet whose sum is Zero.");
        } else {
            System.out.print("All the triplets are: ");
            for( int[] printTriplets : result) {
                System.out.println(Arrays.toString(printTriplets));
            }
        }

        sc.close();

    }

    List<int[]> threeSumFunction( int [] array ) {

        List<int[]> resultTriplets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                for (int k = j+1; k < array.length ; k++) {
                     if( i!=j && i!=k && j!=k && (array[i] + array[j] +array[k] == 0)) {
                         resultTriplets.add(new int[] { array[i], array[j], array[k]});
                     }
                }
            }
        }
       return resultTriplets;
    }
}
