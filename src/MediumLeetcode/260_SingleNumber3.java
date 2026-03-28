package MediumLeetcode;

import java.util.*;

class SingleNumber3 {
    public int[] singleNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                ans[i] = key;
                i++;
            }
        }

        return ans;
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

        SingleNumber3 solution = new SingleNumber3();
        int[] result = solution.singleNumber(arr);

        System.out.println("The two single numbers are: " + Arrays.toString(result));

        sc.close();
    }
}
