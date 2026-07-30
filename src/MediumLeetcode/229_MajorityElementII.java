package MediumLeetcode;

import java.util.*;

class MajorityElementII {
    // TC: O(n)
    // SC: O(n)
    public static List<Integer> majorityElementBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of each element
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        // Find elements having frequency > n/3
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> result = majorityElementBetter(nums);

        System.out.println("Majority Elements: " + result);

        sc.close();
    }
}