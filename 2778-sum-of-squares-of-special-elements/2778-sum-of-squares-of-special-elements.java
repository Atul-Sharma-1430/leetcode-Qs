class Solution {
    public int sumOfSquares(int[] nums) {
        // final ans
        int ans = 0;

        // 1 to len
        for (int i = 1; i <= nums.length; i++) {

            // agar i divide krta h 
            if (nums.length % i == 0) {

                // toh i-1 wale ka sq lenge cause internally array 0 base pe hi kaam krta h humnebas usko 1 ki trh treat kiya h 
                ans += (nums[i - 1] * nums[i - 1]);
            }
        }
        return ans;
    }
}