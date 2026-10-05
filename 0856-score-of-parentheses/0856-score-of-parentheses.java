class Solution {
    public int scoreOfParentheses(String s) {


        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                depth++; // opening bracket aaya toh depth increase
            } else {
                depth--; // closing bracket aaya toh depth decrease

                // agar ) ke just pehle ( tha, toh mtlb ek pair mila
                if (s.charAt(i - 1) == '(') {

                    // () ka score 1 hota hai toh vo jitne depth par hai utne baar 2 se multiplyy
                    score += Math.pow(2, depth);
                }
            }
        }

        return score;
    }
}