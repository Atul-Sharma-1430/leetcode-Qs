class Solution {
    public String reverseWords(String s) {
        // Solution 2 - Using StringBuilder
        StringBuilder rev = new StringBuilder("");

        int i = s.length() - 1;
        while (i >= 0) {

            // Agar end me spaces hai toh vo sab skip krke first word pe pahucho right side se
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // Agar string end ho gya toh leave kr do
            if (i < 0) {
                break;
            }

            // Ab ye j jo word mila us word ke st letter tak pahuchne keliye
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Vo wale word ko left se right copy kro
            for (int k = j + 1; k <= i; k++) {
                rev.append(s.charAt(k));
            }

            // and space add kro
            rev.append(" ");

            // Fir add krne ke baad prev word ke last char pe pahucho
            i = j;
        }

        // first word add krne ke baad bhi ek aur baar space add ho jaayega toh isliye trim kr do 
        return rev.toString().trim();






        // Solution 1
        //This logic is optimal but using String can cause inefficiency cz for each word we are creating a new string as Strngs are immutable hence we should use StringBuilder

        // String rev = "";

        // int i = s.length() - 1;
        // while (i >= 0) {

        //     // Agar end me spaces hai toh vo sab skip krke first word pe pahucho right side se
        //     while (i >= 0 && s.charAt(i) == ' ') {
        //         i--;
        //     }

        //     // Agar string end ho gya toh leave kr do
        //     if (i < 0) {
        //         break;
        //     }

        //     // Ab ye j jo word mila us word ke st letter tak pahuchne keliye
        //     int j = i;
        //     while (j >= 0 && s.charAt(j) != ' ') {
        //         j--;
        //     }

        //     // Vo wale word ko left se right copy kro
        //     for (int k = j + 1; k <= i; k++) {
        //         rev += s.charAt(k);
        //     }

        //     // and space add kro
        //     rev += " ";

        //     // Fir add krne ke baad prev word ke last char pe pahucho
        //     i = j;
        // }

        // // first word add krne ke baad bhi ek aur baar space add ho jaayega toh isliye trim kr do 
        // return rev.trim();
    }
}