class Solution {
    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;




        // TC : O (log n)
        // int left = 0;
        // int right = nums.length - 1;

        // while (left <= right) {
        //     int mid = left + (right - left) / 2;

        //     if (nums[mid] == target) {
        //         return mid;
        //     } else if (nums[mid] > target) {
        //         right = mid - 1;
        //     } else {
        //         left = mid + 1;
        //     }
        // }

        // return left;




        // TC : O(n)
        // if (target < nums[0]) {
        //     return 0;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == target) {
        //         return i;
        //     }
        //     if (i < nums.length - 1 && nums[i] < target && nums[i + 1] > target) {
        //         return i + 1;
        //     }
        // }
        // return nums.length;
    }
}