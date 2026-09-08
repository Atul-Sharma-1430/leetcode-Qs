class Solution {
    public int countCommas(int n) {

        // Solution 1
        if (n < 1000) {
            return 0;
        }

        return n - 1000 + 1;





        // Solution 2
        // if (n < 1000) {
        //     return 0;
        // }

        // int len = 0;
        // int temp = n;

        // while (temp != 0) {
        //     len++;
        //     temp /= 10;
        // }

        // int commas = 0;
        // if (len % 3 == 0) {
        //     commas = (len / 3) - 1;
        // } else {
        //     commas = len / 3;
        // }

        // int totalNums = n - 1000 + 1;
        // return totalNums * commas;

    }
}