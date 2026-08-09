class Solution {
    public int findMin(int[] nums) {
        
        // Solution 2

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // Agar nums[mid] >= nums[left] hai toh left se mid tak ka part sorted hai 
            if (nums[mid] >= nums[left]) {
                // check agar nums[left] mere current min se kam hai toh vo min hua and ab humney left part ka min le liya toh right side check kro kya pta usse chhota koi aur mil jaaye
                if(nums[left] < min) {
                    min = nums[left];
                }

                // Sorted left part ka minimum mil gaya hai isliye ab us part ko eliminate karke right side me search karo.
                left = mid + 1;
            } else {
                // Agar nums[mid] < nums[left] hai toh minimum mid ya uske left side me ho sakta hai.
                if(nums[mid] < min) {
                    min = nums[mid];
                }

                // nums[mid] ko minimum ke liye consider kar liya hai isliye ab left side me search karo.
                right = mid - 1;
            }
        }

        return min;






        //Solution 1

        // int left = 0;
        // int right = nums.length - 1;

        // while (left < right) {
        //     int mid = left + (right - left) / 2;

        //     // Agar nums[mid] > nums[right] hai toh minimum definitely mid ke right side me hoga.
        //     if (nums[mid] > nums[right]) {
        //         left = mid + 1;
        //     } else {
        //         // Otherwise minimum mid ya uske left side me ho sakta hai isliye mid ko eliminate nahi karna hai.
        //         right = mid;
        //     }
        // }

        // Jab left == right ho jayega toh wahi index minimum element ka hoga.
        // return nums[left];
    }
}