class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];
            int sum = 0;
            while (temp != 0) {
                int last = temp % 10;
                sum += last;
                temp /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}