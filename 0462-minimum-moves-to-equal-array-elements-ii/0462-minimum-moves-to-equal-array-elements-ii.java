class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;
        int i = 0;
        while (i < nums.length / 2) {
            moves += nums[nums.length / 2] - nums[i];
            i++;
        }
        
        while (i < nums.length) {
            moves += nums[i] - nums[nums.length / 2];
            i++;
        }

        return moves;

    }
}