class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums.length == 0) {
            return ans;
        }

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }

            if (nums[i] < smallest) {
                smallest = nums[i];
            }
        }

        boolean[] hash = new boolean[largest - smallest + 1];

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i] - smallest] = true;
        }

        for (int i = 0; i < hash.length; i++) {
            if (!hash[i]) {
                ans.add(i + smallest);
            }
        }

        return ans;
    }
}