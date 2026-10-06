class Solution {
    public int minAddToMakeValid(String s) {

        // agar empty h toh 0
        if (s.length() == 0) {
            return 0;
        }

        // agar 1 hai toh 1 hi add krna padega bs
        if (s.length() == 1) {
            return 1;
        }

        // balance hai ki nhi ye dekhega
        int count = 0;

        // agar bina open ke close aa gya toh us close eale ke liye open store krega
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            // agar open aaya toh count++
            if (s.charAt(i) == '(') {
                count++;
            }

            // closse aaya toh do contiion rhega
            else {

                // agar close bina open ke aaya gya toh uske liye ek add hoga
                if (count == 0) {
                    ans++;
                }

                // agar pahle open aa chuka hai toh ye wala close uske liye rhega
                else {
                    count--;
                }

            }
        }

        // last me dono ka sum cz dono alag alag cases me kitna add hoga vocount kr rhe h
        return count + ans;
    }
}