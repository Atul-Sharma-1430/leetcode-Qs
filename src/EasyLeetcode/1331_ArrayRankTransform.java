package EasyLeetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class ArrayRankTransform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Rank Transformed Array: "
                + Arrays.toString(arrayRankTransform(arr)));

        sc.close();
    }

    // TC: O(N log N)
    // SC: O(N)

    // Approach:
    // 1. Create a copy of the original array.
    // 2. Sort the copied array to determine the rank order.
    // 3. Store each unique element and its rank using HashMap.
    // 4. Replace original array elements with their corresponding ranks.
    public static int[] arrayRankTransform(int[] arr) {

        int[] cpyArr = new int[arr.length];

        System.arraycopy(arr, 0, cpyArr, 0, arr.length);

        Arrays.sort(cpyArr);

        // To store element and its rank
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;

        for (int j : cpyArr) {
            // Assign rank only to unique elements
            if (!rankMap.containsKey(j)) {
                rankMap.put(j, rank++);
            }
        }

        // Replace values with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}
