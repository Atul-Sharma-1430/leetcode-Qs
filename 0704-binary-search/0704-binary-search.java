class Solution {
    // public static int bsrec(int[] nums, int left, int right, int target) {
    //     if (left > right) {
    //         return -1;
    //     }

    //     int mid = left + (right - left) / 2;

    //     if (nums[mid] == target) {
    //         return mid;
    //     } else if (nums[mid] > target) {
    //         return bsrec(nums, left, mid - 1, target);
    //     }

    //     return bsrec(nums, mid + 1, right, target);
    // }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;




        
        // return bsrec(nums, 0, nums.length - 1, target);
    }
}