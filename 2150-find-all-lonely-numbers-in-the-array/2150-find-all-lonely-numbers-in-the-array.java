class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        // har number ki frequency store karenge
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        // map ko traverse karenge
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            // agar number sirf ek baar aaya hai
            if (entry.getValue() == 1) {
                int val = entry.getKey();
                int prev = val - 1;
                int next = val + 1;

                // agar piche aur aage wale dono nums present nahi hain
                if (!map.containsKey(prev) && !map.containsKey(next)) {
                    ans.add(val);
                }
            }
        }

        return ans;
    }
}