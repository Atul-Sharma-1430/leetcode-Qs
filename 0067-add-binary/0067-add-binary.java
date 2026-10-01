class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder ans = new StringBuilder("");

        while (i >= 0 || j >= 0) {
            int num1 = 0;
            int num2 = 0;

            if (i >= 0) {
                num1 = a.charAt(i) - '0';
            }

            if (j >= 0) {
                num2 = b.charAt(j) - '0';
            }

            int sum = num1 + num2 + carry;

            ans.append(sum % 2);

            carry = sum / 2;

            i--;
            j--;
        }

        // agar last mein carry bach gaya
        if (carry != 0) {
            ans.append(carry);
        }

        return ans.reverse().toString();
    }
}