class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            if (target == nums[i]) {
                ans.add(i);
            }
            i++;
        }

        return ans;
    }
}