class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = 0;
            int[] hash = new int[128];

            for (int j = i; j < s.length(); j++) {
                if (hash[s.charAt(j)] != 0) {
                    break;
                } else {
                    hash[s.charAt(j)]++;
                    curr++;
                }

                max = Math.max(max, curr);
            }
        }

        return max;
    }
}