class Solution {
    public int minInsertions(String s) {

        int count = 0; // kitne close chahiye vo track karega
        int ans = 0; // kitne extra open add karne pade

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Har open ke liye 2 close chahiye
                count += 2;

                /// agar beech me 1 closing aaya and fir open aa gya toh ek close aadd krna  padega pahle wale k liye
                if (count % 2 != 0) {
                    ans++;
                    count--;
                }
            } else {
                // Har closing ke liye count decrease karo
                count--;

                // Agar bina opening ke close aa gaya
                if (count < 0) {
                    ans++; // toh Us close ke liye ek open add kro
                    count += 2; // and Then us open ke liye 2 close aayega kyuki current wala close toh uper pahle hi minus kr diya 
                }
            }
        }

        return ans + count;
    }
}

// )() 1 open 1 close fir 1 close
// ())) 1 open 1 close 
// ) 1 opn 1 cls