class Solution {
    // basically 0 ka index find kro and then don directn me check kro ki sorted hai ya nhi 
    public int minOperations(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;

        // Array me 0 kis index par present hai wo find kr rhe hai
        while (nums[zeroIndex] != 0) {
            zeroIndex++;
        }

        boolean increasing = true, decreasing = true;

        // 0 se start krke circular order me pura array check kenge
        for (int k = 0; k < length && (increasing || decreasing); k++) {

            // Circular indexingg use kr rhe hai taaki last ke baad fir se 0 index par aa ske
            int current = nums[(zeroIndex + k) % length];

            // Check kr rhe hai ki elements 0, 1, 2, 3... ke order me hain ya nhi
            increasing &= current == k;

            // Check kr rhe hai ki elements reverse circular order me hain ya nhi
            /// llike 0 n-1 fir n-2 aise
            decreasing &= current == (length - k) % length;
        }

        // Agar increasing order possible hai toh left rotation ya reverse ke through minimum operations calculate krke return kr rhe hai
        if (increasing) {
            return Math.min(zeroIndex, length - zeroIndex + 2);
        }

        // Agar decreasing circular order possible hai, toh reverse aur rotation ke different combinations me minimum operations return kr rhe hai
        if (decreasing) {
            return Math.min(zeroIndex + 2, length - zeroIndex);
        }

        // Agar dono circular orders me se koi bhi match nhi hota toh allowed operations se array sort nhi ho skta
        return -1;
    }
}