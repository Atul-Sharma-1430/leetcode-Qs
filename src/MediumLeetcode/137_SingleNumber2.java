package MediumLeetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SingleNumber2 {

    // Not Optimal
    // TC = O(n), SC = O(n)
    public int singleNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                ans = key;
            }
        }

        return ans;
    }

    // Optimal
    // TC = O(n), SC = O(1)
    public int singleNumberOptimal(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SingleNumber2 solution = new SingleNumber2();
        int result = solution.singleNumber(arr);

        System.out.println("The single number is: " + result);

        sc.close();
    }
}
