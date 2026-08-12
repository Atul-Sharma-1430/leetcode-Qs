class Solution {
    public static boolean isPossible(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int totalBq = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            // Agar given bloomDay[i] ki jo value hai vo day se kam ya equak hoga means us din ka flower bloom ho chuk ahoga toh count++ kr do
            if (bloomDay[i] <= day) {
                count++;
            } else {
                // Agar value greater hai means us din abhi tak flower bloom nhi hua hai toh us time hum piche check krenge ki jitne bhi days me consecutive bloom hua hai kya usme se hum koi bouquet bna skte hain ya nhi agar bna skte hai toh totalBq count increase kr do and count ko wapas zero kr do aage check krne ke liye
                totalBq += count / k;
                count = 0;
            }
        }

        // agar last me bhi kuch count mila toh uske liye bhi check krenge ki kya usme se koi buke ban skta hai n nhi 
        totalBq += count / k;

        // Agar mera totalBq ki value jo given day pe mil rha hai vo m ya usse bda hai means hum given day pe m buke bna skte hain toh vo day ke liye true return kr do 
        return totalBq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        // Agar total flowers hi m * k se kam hain toh bouquets banana possible nahi hai kyuki humey diff diff days se chhose krna hai toh miin rewuirement
        if (bloomDay.length < (long)m * k) {
            return -1;
        }

        // Binary search ki range ke liye minimum aur maximum bloom day nikana is imortant
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            min = (int) Math.min(bloomDay[i], min);
            max = (int) Math.max(bloomDay[i], max);
        }

        int left = min;
        int right = max;

        while (left <= right) {

            // range me se mid ko as random day choose krenge
            int mid = left + (right - left) / 2;

            // agar us din mera true aa rha hai means vo mera ek possible ans ho skta hai 
            if (isPossible(bloomDay, mid, m, k)) {

                // toh hum right side se kam kr denge kyuki hum ye chek krenge ki kya pta koi aur min day miljaaye 
                right = mid - 1;

            } else {

                // Agar bouquets nahi ban rahe toh days ko increase krna padega
                left = mid + 1;
            }
        }

        // Loop ke end mein left ans ko point krega
        return left;
    }
}