class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            // Agar right wala element bada hai toh ho sakta hai ki uske aage koi peak element ho, agar aage koi nahi mila toh bhi greatest element peak ho sakta hai
            if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            }

            // Agar left wala element bada hai toh peak left side me hogi, same logic as upar
            else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }

            // Agar dono neighbours mid se bade nahi hain toh mid hi peak element hai
            else {
                return mid;
            }
        }

        // Jab left aur right same ho jayenge toh wahi peak element ka index hoga
        return right;





        // int ans = -1;
        // for (int i = 0; i < nums.length; i++) {

        //     if (i == 0) {
        //         if (nums[i] > nums[i + 1]) {
        //             return i;
        //         }

        //     } else if (i == nums.length - 1) {
        //         if (nums[i] > nums[i - 1]) {
        //             return i;
        //         }

        //     } else {
        //         if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
        //             ans = i;
        //             break;
        //         }
        //     }
        // }

        // return ans;
    }
}