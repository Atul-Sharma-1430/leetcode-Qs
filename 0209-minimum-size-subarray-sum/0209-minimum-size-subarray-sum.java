class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE; 
        int left = 0; 
        int sum = 0; 

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i]; // Current element ko sum mein add 
            // Jab tak sum target ke equal ya greater hai
            while (sum >= target) { 
                // Minimum length update karo
                min = Math.min(min, i - left + 1); 
                // Leftmost element ko sum se remove karo
                sum -= nums[left]; 
                left++; 
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min; 
















        // int min = Integer.MAX_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {

        //         sum += nums[j];
        //         if (sum >= target) {
        //             if (j - i + 1 < min) {
        //                 min = j - i + 1;
        //             }
        //             break;
        //         }
        //     }
        // }

        // return min == Integer.MAX_VALUE ? 0 : min;
    }
}