package EasyLeetcode;

import java.util.Scanner;

class LongestPalindrome {
    // TC: O(n)
    // SC: O(1)
    public static int method1(String s) {
        int[] freq = new int[52];

        // Count frequencies of characters
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                freq[s.charAt(i) - 'a']++;
            } else {
                freq[s.charAt(i) - 'A' + 26]++; // for capital letters indices st from 26
            }
        }

        int len = 0;
        boolean singleHasTaken = false; // 1 ko lene ke liye beech me aa skta hai
        boolean hasOddFreq = false; // koi add hua toh usko centre me rakh skte hain taaki len 1 se badh jaaye

        for (int i = 0; i < freq.length; i++) {
            // agar 0 toh skip
            if (freq[i] == 0) {
                continue;
            }
            //agar 1 hai and previously 1 nhi liya gya hai toh leke mark kr do le liya gya hai
            else if (freq[i] == 1 && !singleHasTaken) {
                len += freq[i];
                singleHasTaken = true;
            }
            // agar even hai toh poora le lo
            else if (freq[i] % 2 == 0) {
                len += freq[i];
            }
            // agar odd hai toh usme se ek kam lo and mark kr do odd hai
            else {
                len += freq[i] - 1;
                hasOddFreq = true;
            }
        }

        // agar string me odd hai and 1 ko maine nhi liya hai tab odd ki wajh se len plus ho jaayega
        // agar 1 ke alava koi odd nhi hota toh 1 ke liye uper pahle hi 1 baar add kr chuke hain
        if (hasOddFreq && !singleHasTaken) {
            len++;
        }

        return len;
    }

    // TC: O(n)
    // SC: O(1)
    public static int method2(String s) {
        int[] freq = new int[52];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                freq[s.charAt(i) - 'a']++;
            } else {
                freq[s.charAt(i) - 'A' + 26]++;
            }
        }

        int len = 0;
        boolean hasOdd = false;

        for (int i = 0; i < freq.length; i++) {

            // if even then add complete value
            if (freq[i] % 2 == 0) {
                len += freq[i];
            }
            // if odd then usme se ek kam add kroo and mark kr do ki odd bhi hai usme
            else {
                len += freq[i] - 1;
                hasOdd = true;
            }
        }

        // agar ek bhi odd present hua means usko beech me daal skte haini isliye uska poora part le skte hain
        // isme 1 ka bhi case cover ho gya kyuki 1 hone se bhi len 1 se hi badh rha tha and koi ek bhi odd hone se bhi len 1 se hi badh rha hai
        return hasOdd ? len + 1 : len;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.println("Method 1 Answer: " + method1(s));
        System.out.println("Method 2 Answer: " + method2(s));

        sc.close();
    }
}