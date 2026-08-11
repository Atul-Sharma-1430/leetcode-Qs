class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Sabse badi pile nikal rahe hain kyuki Koko ki maximum possible speed maximum pile ke equal ho sakti hai, usse jyada bhi ho skta hai but usse jyda leke kuch fayda nhi hours utne hi lagenge jitna max pe lagega toh isliye array ka max value hi lo taaki binary search me time kam lage
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        // Binary search ki range 1 se maximum tak hoga kyuki minimum speed 1 aur maximum speed max value hi ho skti h
        int left = 1;
        int right = max;

        while (left <= right) {

            // Mid ko current eating speed maan kar check karenge ki Koko h hours ke andar saari bananas kha sakta hai ya nahi.
            int mid = left + (right - left) / 2;

            // har selected speed pe kitna hrs lag rha hai total vo store krega
            long temp = 0;
            for (int i = 0; i < piles.length; i++) {
                // Ceiling division use kar rahe hain taaki aadhi pile ke liye bhi poora 1 hour count ho aisa condition hai
                temp += (piles[i] + mid - 1) / mid;
            }

            // Agar required hours h se kam ya equal hain toh current speed valid hai, isliye aur chhoti speed search karenge.
            if (temp <= h) {
                right = mid - 1;
            } else {
                // Agar required hours h se zyada hain toh current speed slow hai, isliye speed badhani padegi.
                left = mid + 1;
            }
        }

        // Loop ke end mein left minimum valid eating speed par point karega, isliye wahi answer return karenge.
        return left;
    }
}
