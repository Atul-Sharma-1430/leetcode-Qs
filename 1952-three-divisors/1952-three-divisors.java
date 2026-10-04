class Solution {
    public boolean isThree(int n) {
        
        // logic: Number ke exactly 3 divisors tabhi hote hain jab number perfect square ho aur uska square root prime ho.

        // cal root
        int root = (int) Math.sqrt(n);

        // check if n is a perfect square
        if (root * root != n) {
            return false;
        }

        // checking if root is prime or not
        for (int i = 2; i * i <= root; i++) {
            if (root % i == 0) {
                return false;
            }
        }

        return root > 1;












        // int count = 0;
        // for (int i = 2; i <= n / 2; i++) {
        //     if (n % i == 0) {
        //         count++;
        //     }
        // }

        // return count == 1;
    }
}