package EasyLeetcode;
import java.util.HashMap;
import java.util.Map;

class SingleNumber {

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
    public int singleNumbeOptimal(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();

        int[] arr = {4, 1, 2, 1, 2};  
        int result = solution.singleNumber(arr);

        System.out.println("The single number is: " + result);
    }
}
