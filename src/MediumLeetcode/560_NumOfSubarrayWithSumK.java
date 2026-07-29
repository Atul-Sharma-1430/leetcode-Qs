package MediumLeetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NumOfSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Brute Force Answer : " + totalSubarraysBrute(nums, k));
        System.out.println("Optimal Answer     : " + totalSubarraysOptimal(nums, k));

        sc.close();
    }

    // TC : O(n²)
    // SC : O(1)
    public static int totalSubarraysBrute(int[] nums, int k) {

        int ans = 0;
        // Har element ko subarray ka starting point maan lo
        for (int start = 0; start < nums.length; start++) {
            int currSum = 0;

            // Starting point se aage ke saare subarrays bnao
            for (int end = start; end < nums.length; end++) {

                // Current element ko sum me add kro
                currSum += nums[end];

                // Agar required sum mil gya to answer increase kr do
                if (currSum == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // TC : O(n)
    // SC : O(n)
    public static int totalSubarraysOptimal(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();

        int sum = 0;
        int ans = 0;

        // Prefix sum 0 starting me ek baar present hai
        prefixMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // prefix sum update kro
            sum += nums[i];

            // Required previous prefix sum nikalo
            int required = sum - k;

            // Agar required prefix sum map me hai
            if (prefixMap.containsKey(required)) {

                // Uski frequency jitni hogi utne valid subarrays milenge
                ans += prefixMap.get(required);
            }

            // Current prefix sum ki frequency store/update kro
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}