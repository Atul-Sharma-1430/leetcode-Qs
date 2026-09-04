class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        // Soltuion 1
        // TC : O(n)
        // SC : O(n)
        int[] array = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            array[i] = max;
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = nums.length - 1; i >= 0; i--) {

            min = Math.min(nums[i], min);
            array[i] = array[i] - min;

            if (array[i] <= k) {
                ans = i;
            }
        }

        return ans;


        // Solution 2
        // TC : O(n^2)
        // SC : O(1)
        // int max = Integer.MIN_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > max) {
        //         max = nums[i];
        //     }

        //     int min = Integer.MAX_VALUE;
        //     for (int j = i; j < nums.length; j++) {
        //         if (nums[j] < min) {
        //             min = nums[j];
        //         }
        //     }

        //     if ((max - min) <= k) {
        //         return i;
        //     }
        // }

        // return -1;
    }
}
