class Solution {
    public String maxSumOfSquares(int num, int sum) {

        // Agar sum, num digits ke maximum sum se jyada hai toh answer possible nahi hai
        if (sum > 9 * num || sum == 0) {
            return "";
        }


        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            // Har digit pe max value 9 ho sakti hai Isliye 9 aur  sum me se min lenge
            int digit = Math.min(9, sum);

            // digit ko add to ans
            ans.append(digit);

            // Current digit ki value ko sum se subtract kar do Taaki next digit ke liye bacha hua sum mil ske
            sum -= digit;
        }

        // Agar sum 0 nhi hua means kuch baki hai toh ans nhi bnega
        if (sum != 0)
            return "";

        return ans.toString();
    }
}