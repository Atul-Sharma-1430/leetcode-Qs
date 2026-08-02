package MediumLeetcode;

import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        ThreeSum Sum3 = new ThreeSum();

        List<int[]> result = Sum3.threeSumFunction(array);
        if (result.isEmpty()) {
            System.out.print("There is no such triplet whose sum is Zero.");
        } else {
            System.out.print("All the triplets are: ");
            for (int[] printTriplets : result) {
                System.out.println(Arrays.toString(printTriplets));
            }
        }

        System.out.println(threeSumBetter(array));

        sc.close();

    }

    // Brute Force
    // TC = O(n^3), SC = O(k)
    List<int[]> threeSumFunction(int[] array) {

        List<int[]> resultTriplets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (i != j && i != k && j != k && (array[i] + array[j] + array[k] == 0)) {
                        resultTriplets.add(new int[]{array[i], array[j], array[k]});
                    }
                }
            }
        }
        return resultTriplets;
    }

    // TC : O(n^2)
    // SC : O(n) + O(no of triplets)
    public static List<List<Integer>> threeSumBetter(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Current i ke liye visited elements store krenge
            Set<Integer> thirdValue = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {

                // get value of third element
                int third = -(nums[i] + nums[j]);

                // Agar required third element pehle mil chuka hai
                if (thirdValue.contains(third)) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    Collections.sort(triplet);
                    set.add(triplet);
                }

                // Current element ko jab tak j lasst tak na pahuche tab tk  ke liye store kr do
                thirdValue.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}
