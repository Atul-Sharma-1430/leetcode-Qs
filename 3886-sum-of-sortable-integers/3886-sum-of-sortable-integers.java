class Solution {
    public int sortableIntegers(int[] nums) {
        int ans = 0;

        for (int k = 1; k <= nums.length; k++) {
            if (nums.length % k != 0) {
                continue;
            }

            boolean valid = true;
            // piche wle subarray ka max store krn k liyue
            int prevMax = Integer.MIN_VALUE;

            // subarrays me divide krnge
            for (int start = 0; start < nums.length; start += k) {
                int end = start + k - 1; // window size

                // Current subarray ka min aur max
                int min = nums[start];
                int max = nums[start];

                // current subaryy me Circular order mein kitne breakin gpt hai vo count karenge
                int breaks = 0;
                for (int j = start; j <= end; j++) {

                    // Current subarray ka min aur maax update karenge
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    // Agar current element next element se bada hai,  toh ek brk pt mila
                    if (j < end && nums[j] > nums[j + 1]) {
                        breaks++;
                    }
                }

                // Last aur first element ke beech sortness check karenge
                if (nums[end] > nums[start]) {
                    breaks++;
                }

                // agart Ek se zyada break pt hain toh rotation se sort nahi hoi skta
                if (breaks > 1) {
                    valid = false;
                    break;
                }

                // agr phle wale subarray ka max, abhi wale  minimum se bada hai toh combined array sorted nahi banega
                if (prevMax > min) {
                    valid = false;
                    break;
                }

                // Current subarray ka maximum next subarray ke liye save karenge
                prevMax = max;
            }

            // Agar saare subarrays valid hain toh k ko answer mein add karenge
            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}