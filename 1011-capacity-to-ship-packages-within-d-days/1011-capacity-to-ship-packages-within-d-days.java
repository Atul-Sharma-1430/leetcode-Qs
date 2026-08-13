class Solution {
    // Given capacity ke liye kitne days lagenge ye calculate karta hai.
    public static int calculateDaysRequired(int[] weights, int capacity) {

        int daysReq = 1;
        int currentLoad = 0;

        for (int i = 0; i < weights.length; i++) {

            // Agar current package add karne par capacity exceed ho jaaye.
            if (weights[i] + currentLoad > capacity) {

                // Current value ko next day ke liye load kar do kyuki isi ki wajah se capacity exceed ho rahi hai.
                currentLoad = weights[i];

                // Naya day start hone ki wajah se days increase kar do.
                daysReq++;

            } else {

                // Jab tak capacity exceed nahi hoti tab tak same day mein package load karo.
                currentLoad += weights[i];
            }
        }

        return daysReq;
    }


    // TC: O(N * log(sum - max))
    // SC: O(1)
    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = Integer.MIN_VALUE;
        int totalWeight = 0;

        // Minimum possible capacity = maximum weight and maximum capacity = total weight.
        for (int i = 0; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            totalWeight += weights[i];
        }

        int left = maxWeight;
        int right = totalWeight;

        int ans = Integer.MAX_VALUE; // Final minimum capacity store karta hai.

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Mid capacity se packages ship karne mein kitne days lagenge vo calculate karo.
            int daysReq = calculateDaysRequired(weights, mid);

            // Agar required days ke andar ship kar sakte hain.
            if (daysReq <= days) {

                ans = mid;

                // Ab aur smaller capacity try karo.
                right = mid - 1;

            } else {

                // Agar chosen capacity se required days se zyada days lag rahe hain toh capacity badhani padegi.
                left = mid + 1;
            }
        }

        return ans;
    }
}