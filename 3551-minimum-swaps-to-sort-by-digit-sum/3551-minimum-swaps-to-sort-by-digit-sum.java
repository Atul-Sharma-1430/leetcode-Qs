
import java.util.*;

class Solution {

    // Number ka digit sum calculate karenge
    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {

        int n = nums.length;

        // Original array ki copy banayenge taki values lost na ho
        int[] arr = nums.clone();

        // Sorted order mein original numbers store karne ke liye
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i];
        }

        // Digit sum ke basis par sort 
        Arrays.sort(sorted, (num1, num2) -> {
            int sum1 = digitSum(num1);
            int sum2 = digitSum(num2);

            if (sum1 != sum2) {
                return sum1 - sum2;
            }

            return num1 - num2;
        });

        // Har original number ka index store karenge
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        // Check karenge ki konsa index visit ho chuka hai
        boolean[] visited = new boolean[n];

        int swaps = 0;

        // Minimum swaps find karne ke liye cycles check karenge
        for (int i = 0; i < n; i++) {
            // Agar index visit hai ya element already correct position pe hai
            if (visited[i] || nums[i] == sorted[i]) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            // Current cycle ke sare indexes visit karenge
            while (!visited[j]) {
                visited[j] = true;

                // Sorted element ki original position find karenge
                j = indexMap.get(sorted[j]);
                cycleSize++;
            }

            // Cycle mein k elements hai toh k-1 swaps lagenge
            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
