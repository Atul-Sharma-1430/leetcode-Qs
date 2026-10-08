class Solution {
    public String removeOuterParentheses(String s) {

        // sabse bahar wale open and close ka index ytrack krega
        int outerOpen = -1;
        int outerClose = -1;

        int count = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // agar open aaya toh ++;
                count++;
                // and agar count 1 hai meanws sabse outer wala hai toh uska indesx store kr lenge
                if (count == 1) {
                    outerOpen = i;
                }
            } else {
                // close pe --;
                count--;
                // agar count 0 aa gya measns outerOpen ke liye outerClose mil gya toh uska iodex store 
                if (count == 0) {
                    outerClose = i;
                }
            }

            // then dono ke beech ka substring nikal ke ans me add
            if (outerOpen != -1 && outerClose != -1) {
                ans.append(s.substring(outerOpen + 1, outerClose));
                // and dono ko firse -1 for aage wal0 ke liuye
                outerOpen = -1;
                outerClose = -1;
            }
        }

        return ans.toString();

















        // sol1
        // int openB = 0; 
        // int closeB = 0; 

        // StringBuilder ans = new StringBuilder();

        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(') {
        //         openB++;
        //         // agar 1 se jyada h openB means pahle outer aa chuka h isliye ye wale ko add krnge
        //         if (openB > 1) {
        //             ans.append(s.charAt(i));
        //         }
        //     } else {
        //         closeB++;
        //         // jab tk openB jyada h tab tk means bahahr wala close nhi aaya h toh add krnge
        //         if (closeB < openB) {
        //             ans.append(s.charAt(i));
        //         }
        //     }

        //     // if dono count same means bahar wale open ke liye bahar wala close mil gya toh dono 0
        //     if (openB == closeB) {
        //         openB = 0;
        //         closeB = 0;
        //     }
        // }

        // return ans.toString();
    }
}