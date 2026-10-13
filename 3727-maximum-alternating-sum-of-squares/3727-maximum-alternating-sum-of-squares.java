class Solution {
    public long maxAlternatingSum(int[] nums) {

        // sabka squar
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // sort taaki alternatively bada chota value plus minus kr ske
        Arrays.sort(nums);

        int i = 0; // subtrackt krne ke liye
        int j = nums.length - 1; // add krne ke liy

        long sum = 0;

        // 1 4 9
        // 1 1 4 4 9 9 

        // last me se bade wali ki value add krenge and st vse chote wale ki value minus
        while (i <= j) {
            sum += nums[j];

            // agar same index aa gya toh usko subtract nhi krna hai firsee
            if (i != j) {
                sum -= nums[i];
            }

            i++;
            j--;
        }

        return sum;

    }
}