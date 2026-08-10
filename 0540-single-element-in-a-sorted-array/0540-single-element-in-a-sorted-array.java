class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // Mid ko even index pe kr do taaki mid aur mid+1 ki pair check kar sake
            if (mid % 2 != 0) {
                mid--;
            }

            // Agar mid aur mid+1 same hain toh ye pair correct hai aur single element right side me hoga
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }

            // Agar pair match nahi hui toh single element mid ya uske left side me hoga
            else {
                right = mid;
            }
        }

        // Jab left == right ho jayega wahi single element ka index hoga
        return nums[left];





        // int xorAll = 0;

        // for (int num : nums) {
        //     xorAll ^= num;
        // }

        // return xorAll;
    }
}