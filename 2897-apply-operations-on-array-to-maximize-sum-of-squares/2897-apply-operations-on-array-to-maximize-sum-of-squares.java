class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1000000007;
        long ans = 0;

        // Har bit kitni baar available hai vo count karne ke liye array banaya Kyuki ek bit ko utni hi baar use kar sakte hain jitni baar vo aayrgi hai
        int[] bits = new int[32];

        // Array ke har number ki bits checking
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                // Agar current position par 1 hai toh uska count++;
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }

        // finding numbr
        for (int i = 0; i < k; i++) {
            long num = 0;
            // Badi bit se start karenge taaki maximum value ka number bn ske
            for (int j = 31; j >= 0; j--) {
                // Agar ye bit abhi available hai toh usey kar lenge
                if (bits[j] > 0) {
                    // Current bit ko number me set kar rahe hain
                    num |= (1L << j);
                    // Ek baar use ho gayi toh iska count kam kar do
                    bits[j]--;
                }
            }

            // Har number ka square add kar rahe hain n mood isliye lagaya taaki answer limit ke andar rahe
            ans = (ans + num * num) % mod;
        }

        return (int) ans;
    }
}
