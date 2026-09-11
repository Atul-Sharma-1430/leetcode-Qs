class Solution {

    // TC : O(n^3)
    // SC : O(1)
    public int totalNumbers(int[] digits) {

        // HashSet use karenge taaki same number duplicate count na ho
        HashSet<Integer> set = new HashSet<>();

        // 1st loop : 1st digit
        for (int i = 0; i < digits.length; i++) {

            // 3agar 1st digit 0 hua toh skip
            if (digits[i] == 0) {
                continue;
            }

            // 2nd loop : for 2nd degit
            for (int j = 0; j < digits.length; j++) {

                // cannot use same number again
                if (i == j) {
                    continue;
                }

                // 3rd loop : for 3rd number
                for (int k = 0; k < digits.length; k++) {

                    // Same copy ko dobara use nahi kar sakte
                    if (i == k || j == k) {
                        continue;
                    }

                    // last num should be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    // 1st digit ko hundreds, 2nd ko tens
                    // aur 3rd digit ko units place par rakhenge
                    int number = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    // Number ko HashSet mein add karenge
                    set.add(number);
                }
            }
        }
        
        return set.size();
    }
}
