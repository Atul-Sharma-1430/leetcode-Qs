class Solution {

    // gcxd
    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }

    public long maxPairStrength(int[] nums) {

        long max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                // gcd
                long gcd = gcd(nums[i], nums[j]);

                // formula
                long strength = ((long) nums[i] * nums[j]) / (gcd * gcd);

                max = Math.max(max, strength);
            }
        }

        return max;
    }
}