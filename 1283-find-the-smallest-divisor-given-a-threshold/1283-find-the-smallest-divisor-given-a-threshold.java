class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        // Array me se maximum value nikal rahe hain kyuki maximum possible divisor max value ho sakta hai
        // ye binary search ka search space nikalne keliye 
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = (int) Math.max(nums[i], max);
        }

        int left = 1; // min possible divisor
        int right = max;
        int ans = max + 1;

        while (left <= right) {
            // Mid ko current divisor maan kar check karenge ki total kitna aayega
            int mid = left + (right - left) / 2;

            // Current divisor se divide karne ke baad total sum store karega
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                // Ceiling division use kar rahe hain
                // (a + b - 1) / b se a/b ka ceil milta hai
                temp += (nums[i] + mid - 1) / mid;
            }

            // Agar total sum threshold se kam ya equal hai toh current divisor possible answer hai
            if (temp <= threshold) {
                // Current divisor ko answer maan lo
                ans = mid;
                // Ab aur chhota divisor check karenge
                right = mid - 1;

            } else {
                // Agar sum threshold se bada hai toh divisor ko increase karna padega taaki quotiennt kam aaye and total kam ho 
                left = mid + 1;
            }
        }

        return ans;
    }
}