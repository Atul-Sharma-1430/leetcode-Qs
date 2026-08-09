class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // [1, 2, 1] with target 1 ke liye fail ho gya isliye left and right dono ke liye bhi check kr lo saath me cause humko bas ye batana hai present hai ya nhi toh ye add krne se ho jayega 
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            // poora q pahle jaisa same hai bas problem kab aa rhi thi Jab nums[left] == nums[right] ho rha hai, tab duplicates ki wajah se ye decide nahi kar paa rhe hain ki left half sorted hai ya right half sorted. Isliye left++ aur right-- karke duplicate boundary elements remove kar dete hain.
            else if (nums[left] == nums[right]) {
                left++;
                right--;
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

        return false;

        // for(int i=0; i<nums.length; i++) {
        //     if(nums[i] == target) {
        //         return true;
        //     }
        // }

        // return false;
    }
}