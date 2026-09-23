class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // same as 3 sum logic

        // TC : O(n log n)
        // SC : O(1)

        // array ko sort karo
        Arrays.sort(nums);

        // starting mein diff is max
        int minDiff = Integer.MAX_VALUE;

        // final ans
        int ans = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            // two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right]; // curr elements ka sum

                // exact target mil gaya toh return kr do
                if (sum == target) {
                    return sum;
                }

                // target aur current sum ka difference
                int diff = Math.abs(target - sum);

                // agar difference chota hai toh update karo
                if (diff < minDiff) {
                    minDiff = diff;
                    ans = sum;
                }

                // sum chota hai toh left badhao
                if (sum < target) {
                    left++;
                }
                // sum bada hai toh right kam karo
                else {
                    right--;
                }
            }
        }

        return ans;
    }
}