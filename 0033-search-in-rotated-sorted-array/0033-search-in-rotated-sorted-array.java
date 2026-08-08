class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted hai
            else if (nums[mid] >= nums[left]) {
                // toh pahle check kro ki kya target left side me hai ki nhi agar left side me rhega toh usi side me check kro
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } // warna right side me hoga 
                else {
                    left = mid + 1;
                }
            }

            // Right half sorted hai
            else {
                // toh pahle check kro ki kya target right side me hai ki nhi agar right side me rhega toh usi side me check kro
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } // warna left side check kro
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}