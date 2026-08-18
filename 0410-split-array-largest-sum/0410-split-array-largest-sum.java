// This problem is same as Painters problem exact same
class Solution {
    public int splitArray(int[] nums, int k) {
        // Agar subarrays k se zyada chahiye aur elements hi kam hain toh har subarray mein at least ek element dena possible nahi hai 
        // Painter problem: Agar painters boards se zyada hain toh har painter ko at least ek board dena possible nahi hai
        if (nums.length < k) {
            return -1;
        }

        // Range of Binary Search 
        // Painter problem: Yahi range maximum time ke liye bhi use hogi
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Ek single element ko split nahi kar sakte isliye minimum possible answer maximum element hoga 
            // Painter problem: Ek single board ko split nahi kar sakte isliye minimum possible time maximum board length hoga
            max = Math.max(max, nums[i]);

            // Maximum possible answer ke liye saare elements ka total sum le sakte hain 
            // Painter problem: Maximum possible time ke liye ek painter ko saare boards de sakte hain
            sum += nums[i];
        }

        // Minimum possible answer kyuki maximum element se kam maximum sum possible nahi hai 
        // Painter problem: Maximum board length se kam time possible nahi hai
        int left = max;

        // Maximum possible answer saare elements ek hi subarray mein aa sakte hain 
        // Painter problem: Saare boards ek hi painter ko de sakte hain
        int right = sum;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check karenge ki kya mid maximum sum rakhkar array ko k parts mein divide karna possible hai 
            // Painter problem: Check karenge ki kya mid maximum time rakhkar boards ko k painters mein divide karna possible hai
            boolean possible = isPossible(nums, mid, k);

            if (possible) {
                // Agar current maximum sum possible hai toh hum aur chhota answer try karenge 
                // kyuki hume minimum possible maximum sum chahiye 
                // Painter problem: Agar current maximum time possible hai toh aur kam maximum time try karenge
                right = mid - 1;

            } else {
                // Agar current maximum sum possible nahi hai toh maximum allowed sum badhana padega 
                // Painter problem: Agar current maximum time possible nahi hai toh maximum allowed time badhana padega
                left = mid + 1;
            }
        }

        // Binary search ke end mein left will be at minimum possible answer 
        return left;
    }

    // Ye function check karega ki given "hrs" maximum limit ke andar kya array ko maximum k parts/subarrays mein divide kar sakte hain 
    // Painter problem: given maximum time ke andar kya boards ko k painters mein divide kar sakte hain

    public static boolean isPossible(int[] nums, int hrs, int k) {
        // Pehla subarray/painter yahin se start kar rahe hain 
        // Painter problem: Pehla painter yahin se boards paint karna start karega
        int total = 1;

        // Current subarray mein abhi tak ka total sum 
        // Painter problem: Current painter ne abhi tak jitne boards paint kiye hain unka total time
        int time = 0;

        for (int i = 0; i < nums.length; i++) {

            // Agar current element add karne ke baad current subarray ka sum given maximum limit se exceed ho raha hai 
            // Painter problem: Agar current board paint karne ke baad current painter ka total time maximum limit se exceed ho raha hai
            if (time + nums[i] > hrs) {

                // Current element ko naye subarray mein daalenge 
                // Painter problem: Current board ko next painter ko allocate karenge
                total++;

                // Naye subarray ka sum current element se start hoga 
                // Painter problem: Naye painter ka time current board se start hoga
                time = nums[i];

            } else {

                // Agar maximum limit exceed nahi ho rahi toh current subarray mein current element add kar do 
                // Painter problem: Agar maximum time exceed nahi ho raha toh current board same painter ko de do
                time += nums[i];
            }
        }

        // Agar required k subarrays ke andar allocation possible hai 
        // Painter problem: Agar required k painters ke andar saare boards allocate ho rahe hain
        return total <= k;
    }
}