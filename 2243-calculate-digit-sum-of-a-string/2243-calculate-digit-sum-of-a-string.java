
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int i = 0;
            String temp = "";
            int sum = 0;

            while (i < s.length()) {
                sum += s.charAt(i) - '0';

                if ((i + 1) % k == 0) {
                    temp += sum;
                    sum = 0;
                }

                i++;
            }

            if (i % k != 0) {
                temp += sum;
            }

            s = temp;
        }

        return s;
    }
}
