class Solution {
    // TC : O(log₅ n)
    // SC : O(1)
    public int trailingZeroes(int n) {

        int count = 0;

        // Trailing zero banne ke liye 2 × 5 = 10 ka pair chahiye
        // Factorial mein 2 ke factors 5 se zyada hote hain
        // Isliye hume sirf total factors of 5 count karne hain
        while (n >= 5) {

            // 5 ke multiples mein kam se kam ek factor of 5 hota hai
            // n ko 5 se divide karke un factors ko count karenge
            n = n / 5;

            // Mile hue factors of 5 ko total count mein add karenge
            // Next iteration mein 25, 125 jaise numbers ke extra 5 factors count honge
            count += n;
        }

        return count;
    }
}
