class Solution {
    public int sortPermutation(int[] nums) {
        // st me ans -1 hai jiske saare bits 1 hote hain
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            // Agar element apni correct index par nahi hai
            if (nums[i] != i) {
                //  toh ans aur glt element ka bitwise AND kareng
                ans &= nums[i];
                // Agar ans 0 ho gaya, toh directly 0 return kar do
                if (ans == 0) {
                    return 0;
                }
            }
        }

        // Saare misplaced elements ka bitwise AND will beans
        return Math.max(0, ans);
    }
}