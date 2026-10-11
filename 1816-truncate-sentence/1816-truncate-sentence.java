class Solution {
    public String truncateSentence(String s, int k) {
        int spaces = 0;

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < s.length()) {

            // count spaces
            if (s.charAt(i) == ' ') {
                spaces++;
            }

            // return if eql spcs
            if (spaces == k) {
                return ans.toString();
            }

            // add curr char
            ans.append(s.charAt(i));
            i++;
        }

        return ans.toString();
    }
}