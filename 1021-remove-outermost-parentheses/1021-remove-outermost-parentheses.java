class Solution {
    public String removeOuterParentheses(String s) {
        int openB = 0; 
        int closeB = 0; 

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openB++;
                // agar 1 se jyada h openB means pahle outer aa chuka h isliye ye wale ko add krnge
                if (openB > 1) {
                    ans.append(s.charAt(i));
                }
            } else {
                closeB++;
                // jab tk openB jyada h tab tk means bahahr wala close nhi aaya h toh add krnge
                if (closeB < openB) {
                    ans.append(s.charAt(i));
                }
            }

            // if dono count same means bahar wale open ke liye bahar wala close mil gya toh dono 0
            if (openB == closeB) {
                openB = 0;
                closeB = 0;
            }
        }

        return ans.toString();
    }
}