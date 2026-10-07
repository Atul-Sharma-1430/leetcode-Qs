class Solution {
    public int numTeams(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    // Ascending order
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        count++;
                    }

                    // Descending order
                    else if (nums[i] > nums[j] && nums[j] > nums[k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}