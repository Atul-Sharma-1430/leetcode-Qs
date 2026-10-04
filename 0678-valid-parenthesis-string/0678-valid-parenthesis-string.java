class Solution {
    public boolean checkValidString(String s) {

        if (s.length() == 1 && s.charAt(0) != '*') {
            return false;
        }

        // same as longest valid check from bot side
        int openB = 0;
        int closeB = 0;
        int star = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openB++;
            } else if (ch == ')') {
                closeB++;
            } else {
                star++;
            }

            if (closeB > openB + star) {
                return false;
            }
        }

        openB = 0;
        closeB = 0;
        star = 0;

        // Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openB++;
            } else if (ch == ')') {
                closeB++;
            } else {
                star++;
            }

            if (openB > closeB + star) {
                return false;
            }
        }

        return true;
    }
}