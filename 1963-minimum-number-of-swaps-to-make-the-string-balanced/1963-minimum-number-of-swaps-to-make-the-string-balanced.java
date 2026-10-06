class Solution {
    public int minSwaps(String s) {

        // Sol 2

        // current balance chek karega
        int count = 0;

        // kitne swaps chahiye
        int swaps = 0;

        for (int i = 0; i < s.length(); i++) {

            // open aaya toh ++;
            if (s.charAt(i) == '[') {
                count++;
            }

            // close aaya toh --;
            else {
                count--;
            }

            // agar balance negative ho gaya matlab extra close aa gaya hai
            if (count < 0) {

                // jitna negative balance hai utne swaps ans
                swaps += count * (-1);

                // swap ke baad balance ko set kr do cause utne aage nopen aa gye 
                count *= -1;
            }
        }

        return swaps;




















        // Sol 1 
        // logic for these kind of balance prpblems
        // Open bracket ke liye count++
        // Close bracket ke liye 2 cses
        // 1- agar close bina open ke aaya haoi 
        // 2- close kisi open ke baad aaya h

        // // balance hai ki nhi ye dekhega
        // int count = 0;

        // // swaps kitne karne padenge
        // int swaps = 0;

        // for (int i = 0; i < s.length(); i++) {

        //     // agar open aaya toh count++
        //     if (s.charAt(i) == '[') {
        //         count++;
        //     }

        //     // close  aaya toh do conditon rhegi
        //     else {

        //         // agar close bina open ke aa gaya toh uske liye ek swap hoga
        //         if (count == 0) {
        //             swaps++;

        //             // swap ke baad ek aage open aa jayega isliye ++
        //             count++;
        //         }

        //         // agar pahle open aa chuka hai  toh ye wala close uske liye rhega
        //         else {
        //             count--;
        //         }
        //     }
        // }

        // return swaps;

    }
}