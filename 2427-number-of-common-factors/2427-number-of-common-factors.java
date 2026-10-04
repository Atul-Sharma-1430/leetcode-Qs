class Solution {

    // gcd
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int commonFactors(int a, int b) {

        // cal gcd of a and b
        int gcd = gcd(a, b);

        // 1 will always be factors
        int count = 1;

        // agar gcd 1 nhi h toh gcd khud bhi ek factor rhega
        if (gcd > 1) {
            count++; // gcd itself
        }

        // other factors
        for (int i = 2; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                count++;

                // to avoid counting the same factor twice
                if ((gcd / i) != i) {
                    count++;
                }
            }
        }

        return count;

















        // // 1 is common divisor
        // int count = 1;

        // // if both are divisible by i then inmcrease count
        // for (int i = 2; i <= Math.min(a, b); i++) {
        //     if (a % i == 0 && b % i == 0) {
        //         count++;
        //     }
        // }

        // return count;
    }
}