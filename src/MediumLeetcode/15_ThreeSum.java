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

    // TC : O(n)
    // SC : O(1)
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int first = nums[i];

            if (i != 0 && first == nums[i - 1]) {
                i++;
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = first + nums[i] + nums[j];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(new ArrayList<>(Arrays.asList(first, nums[j], nums[k])));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                }
            }

            i++;
        }

        return ans;
    }
}
