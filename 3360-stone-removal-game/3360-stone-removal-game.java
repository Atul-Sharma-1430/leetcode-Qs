class Solution {
    public boolean canAliceWin(int n) {
        int first = 10;
        while (n >= first) {
            n -= first;
            first--;
        }

        return first % 2 != 0;
    }
}