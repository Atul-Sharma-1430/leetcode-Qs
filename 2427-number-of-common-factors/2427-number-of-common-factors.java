class Solution {
    public int commonFactors(int a, int b) {

        // 1 is common divisor
        int count = 1;

        // if both are divisible by i then inmcrease count
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }

        return count;
    }
}