class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long ans = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                count = 0;
            } else {
                count++;
                ans += count;
            }

            i++;
        }

        return ans;
    }
}