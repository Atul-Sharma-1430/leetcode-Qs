class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> combo = new HashSet<>(); 
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                combo.add(nums.get(j));
                ans += combo.size() * combo.size();
            }
            combo.clear();
        }

        return ans;
    }
}