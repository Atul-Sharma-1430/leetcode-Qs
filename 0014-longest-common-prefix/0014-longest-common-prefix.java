class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Pehli string ko common prefix maan lenge kyuki uske basis pe aage wale substrings nikalenge
        String s1 = strs[0];

        // Baaki strings ke saath ek ek karke compare karenge
        for (int i = 0; i < strs.length; i++) {
            if (i + 1 < strs.length) {

                // dono strings ka common prefix ko store karne ke liye
                String ans = "";
                // Next wali string 
                String s2 = strs[i + 1];

                // dono string ke chars ko ek ek krke compare krenge 
                for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {

                    // Agar dono strings ke current characters same hain ans mein add karenge
                    if (s1.charAt(j) == s2.charAt(j)) {
                        ans += s1.charAt(j);
                    } 
                    // jaisehi first char unmatched milega tab comparing band kr do 
                    else {
                        break;
                    }
                }

                // Jo common prefix mila usko s1 bana denge Ab aaage wali string is wali se compare krenge and jitna match hoga usko again ans me store krke fir s1 me daal denge 
                s1 = ans;
            }
        }

        // last me s1 me ans rhega
        return s1;
    }
}