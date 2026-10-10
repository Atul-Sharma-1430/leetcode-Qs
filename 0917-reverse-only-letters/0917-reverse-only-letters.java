class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder();

        int start = 0;
        int end = s.length() - 1;

        while (start < s.length()) {

            // agar start pe letter nhi hai toh usko same position pe add kro
            if (!Character.isLetter(s.charAt(start))) {
                ans.append(s.charAt(start));
                start++;
            } else {

                // end se non-letters ko skip kro
                while (end >= 0 && !Character.isLetter(s.charAt(end))) {
                    end--;
                }

                // last wala letter ans me add kro
                ans.append(s.charAt(end));

                start++;
                end--;
            }
        }

        return ans.toString();
    }
}