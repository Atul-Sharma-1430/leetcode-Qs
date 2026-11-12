class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;

        int ans1 = 1;
        int ans2 = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                inc++;
            } else {
                inc = 1;
            }

            if (nums[i + 1] < nums[i]) {
                dec++;
            } else {
                dec = 1;
            }

            ans1 = Math.max(ans1, inc);
            ans2 = Math.max(ans2, dec);
        }

        return Math.max(ans1, ans2);
    }
}