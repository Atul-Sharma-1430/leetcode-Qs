class Solution {
    public int smallestNumber(int n, int t) {

        int i = 0;

        while (true) {
            int num = n + i;
            int temp = num;
            int prod = 1;

            while (temp != 0) {
                int last = temp % 10;
                temp /= 10;

                if (last == 0) {
                    prod = 0;
                    break;
                }

                prod *= last;
            }

            if (prod % t == 0) {
                return num;
            }

            i++;
        }
    }
}