class Solution {
    public String concatHex36(int n) {
        StringBuilder ans = new StringBuilder();

        char[] hash = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        int sq = n * n;
        while (sq != 0) {
            int rem = sq % 16;
            ans.append(hash[rem]);
            sq /= 16;
        }
        StringBuilder ans2 = new StringBuilder();

        long cube = (long) n * n * n;
        while (cube != 0) {
            long rem = cube % 36;
            ans2.append(hash[(int) rem]);
            cube /= 36;
        }


        return ans.reverse().append(ans2.reverse()).toString();
    }
}
