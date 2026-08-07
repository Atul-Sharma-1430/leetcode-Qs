class Solution {
    public int[] findErrorNums(int[] nums) {

        long n = nums.length;
        long sn = (n * (n + 1)) / 2;
        long sn2 = (n * (n + 1) * ((2 * n) + 1)) / 6;

        long s1 = 0;
        long s12 = 0;

        for (int i = 0; i < n; i++) {
            s1 += (long) nums[i];
            s12 += (long) nums[i] * (long) nums[i];
        }

        long value1 = sn - s1;
        long value2 = sn2 - s12;
        value2 = value2 / value1;

        long x = (value1 + value2) / 2;
        long y = x - value1;

        return new int[] { (int) y, (int) x };




        // int[] ans = new int[2];

        // for (int i = 0; i < nums.length; i++) {
        //     int index = Math.abs(nums[i]) - 1;

        //     if (nums[index] > 0) {
        //         nums[index] = nums[index] * (-1);
        //     }
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > 0) {
        //         ans[0] = nums[i];
        //         ans[1] = i+1;
        //         break;
        //     }
        // }

        // return ans;
    }
}