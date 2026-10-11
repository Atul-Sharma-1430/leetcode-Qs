class Solution {
    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int ans = 0;

        for (int i = 0; i < chars.length; i++) {

            char ch = chars[i];
            sb.append(ch); // Current character ko add 
            count = 0;

            // Same consecutive characters ka count nikalo
            while (i < chars.length && ch == chars[i]) {
                count++;
                i++;
            }

            ans++; // Current character ke liye length increase ki

            if (count > 1) {
                sb.append(count); // Count ko compressed string mein add kiya
                int temp = count;

                // Count mein kitne digits hain, woh calculate kiya
                while (temp != 0) {
                    ans++;
                    temp /= 10;
                }
            }

            i--; // Extra increment ko adjust kiya
        }

        int i = 0;
        // Compressed string ko original array mein copy kiya
        while (i < sb.length()) {
            chars[i] = sb.charAt(i);
            i++;
        }

        return ans; // Compressed array ki valid length return ki
    }
}