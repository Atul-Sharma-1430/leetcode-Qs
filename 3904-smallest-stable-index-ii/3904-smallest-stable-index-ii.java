class Solution {
    public int firstStableIndex(int[] nums, int k) {

        // Same solution as part one
        // TC : O(n)
        // SC : O(n)

        int[] maxArray = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            maxArray[i] = Math.max(nums[i], max);
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);

            if (maxArray[i] - min <= k) {
                ans = i;
            }
        }

        return ans;
    }
} 