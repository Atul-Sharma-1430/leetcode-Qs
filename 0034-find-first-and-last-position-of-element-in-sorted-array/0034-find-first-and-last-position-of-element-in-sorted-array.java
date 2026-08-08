class Solution {
    public int[] searchRange(int[] nums, int target) {

        // First and last occurence means lower bound and upper bound
        int left = 0;
        int right = nums.length - 1;
        int lowerB = -1;

        // First occurrence = Lower Bound
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lowerB = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // agar element present hi nhi hai toh -1 -1 
        if (lowerB == -1) {
            return new int[] { -1, -1 };
        }

        int low = 0;
        int high = nums.length - 1;
        int upperB = nums.length;

        // Last Occurence = upperBound - 1
        while (low <= high) {
            int midd = low + (high - low) / 2;

            if (nums[midd] == target) {
                low = midd + 1;
            } else if (nums[midd] > target) {
                upperB = midd;
                high = midd - 1;
            } else {
                low = midd + 1;
            }
        }

        return new int[] { lowerB, upperB - 1 };








        // if (nums.length == 1 && target == nums[0]) {
        //     return new int[] { 0, 0 };
        // }
        // int low = 0;
        // int high = nums.length - 1;
        // while (low <= high) {
        //     int mid = low + (high - low) / 2;
        //     if (nums[mid] == target) {
        //         int i = mid;
        //         int j = mid;
        //         while (j <= nums.length - 1 && nums[j] == target) {
        //             j++;
        //         }
        //         while (i >= 0 && nums[i] == target) {
        //             i--;
        //         }
        //         return new int[] { i + 1, j - 1 };
        //     }
        //     if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }
        // return new int[] { -1, -1 };
    }
}