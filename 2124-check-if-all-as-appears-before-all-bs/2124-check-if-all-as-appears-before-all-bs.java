class Solution {
    public boolean checkString(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) != 'b') {
            i++;
        }

        if (i == s.length())
            return true;

        while (i < s.length()) {
            if (s.charAt(i) == 'a') {
                return false;
            }
            i++;
        }

        return true;
    }
}