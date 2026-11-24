class Solution {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }

    public int maxLength(int[] nums) {

        // ans
        int maxLen = 1;

        // Subarray ka starting index fix karenge
        for (int i = 0; i < nums.length; i++) {

            // Har naye subarray ke liye values initialize karenge
            long prod = 1;
            long l = 1;
            int g = 0;

            // slididng window
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = (l / gcd((int) l, nums[j])) * nums[j];
                if (prod == l * g) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
