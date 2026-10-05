class Solution {
    public int reverseBits(int n) {
        int temp = n;

        StringBuilder sb = new StringBuilder();

        // n ko 32 bit binary mein convert karo
        for (int i = 0; i < 32; i++) {
            int rem = temp % 2;
            sb.append(rem);
            temp /= 2;
        }

        // binary ko decimal mein convert karo
        // temp me already reverse store hua hai isliye no reverse
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans = ans * 2 + (sb.charAt(i) - '0');
        }

        return ans;
    }
}