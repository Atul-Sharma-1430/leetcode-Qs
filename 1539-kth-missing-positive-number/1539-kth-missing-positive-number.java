class Solution {
    // // curr selected value ke pahle kitne positive numbers missing hain ye calculate karta hai.
    // public static int totalPrevMissing(int[] nums, int curr) {

    //     int count = 0;
    //     int i = 0;
    //     // Sorted array hai toh hum ye check krenge ki curr value ke pahle kitne values usse chhote present hai arry me
    //     while (i < nums.length && nums[i] <= curr) {
    //         count++;
    //         i++;
    //     }

    //     // last me jitna number present hai and current ko minus kr denge toh kitna number missing hai vo pta chal jaayega
    //     return curr - count;
    // }

    public int findKthPositive(int[] nums, int k) {

        // int max = 0;

        // // Array ka maximum element find kar rahe hain.
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] - max >= 0) {
        //         max = nums[i];
        //     }
        // }

        // // Answer 1 se start hoga 
        // int left = 1;
        // // Agar array ke andar 1 se leke sabhi elem present hain and humse array ki lengeth se jyada size ka koi (k) puch liya toh us time max possible ans max + k hi ho paayega usse jyada nhi jaayega
        // int right = max + k;

        // int ans = 0;

        // while (left <= right) {
        //     int mid = left + (right - left) / 2;

        //     // jo value humney select kiya hum dekhenge ki usse pahle kitne numbers missing haiin
        //     int prevTotalMissing = totalPrevMissing(nums, mid);

        //     // Agar mid tak k ya usse zyada numbers missing hain matlab mera mid kth missing positive nhi hai ye kth se jyada missing positive 
        //     if (prevTotalMissing >= k) {

        //         // toh us time hum ans ko store kr lenge and 
        //         ans = mid;

        //         // usse bhi chote possible and ke liye check krenge isliye right side ko trim kr do
        //         right = mid - 1;

        //     } else {
        //         // Agar total missing numbers mid ke pahle k se kam hai toh iska matlab mera kth mmissing positive kahhi aage aayega isliye left side ko trim kr do
        //         left = mid + 1;
        //     }
        // }

        // return ans;









        // Solution 2
        // Isme hum ye dhudh rhe hain ki ans humara kaunse index ke beech me aayega
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // mid index tak kitne positive numbers missing hain
            int missingTillMid = nums[mid] - mid - 1;

            // Agar mid tak k ya usse zyada numbers missing hain toh answer left side me ho sakta hai
            if (missingTillMid >= k) {
                right = mid - 1;

            } else {
                // Agar mid tak k se kam numbers missing hain toh answer right side me hoga
                left = mid + 1;
            }
        }

        // left vo position store karega jahan se kth missing number milega
        // left + k karne par kth missing positive number mil jayega
        return left + k;
    }
}