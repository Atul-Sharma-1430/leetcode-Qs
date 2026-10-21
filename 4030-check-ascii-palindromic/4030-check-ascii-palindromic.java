class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i);
            StringBuilder temp = new StringBuilder();

            while (num > 0) {
                temp.append(num % 2);
                num = num / 2;
            }

            while (temp.length() < 8) {
                temp.append('0');
            }

            binary.append(temp.reverse());
        }

        // inbuilt method
        // for (int i = 0; i < s.length(); i++) {
        //     binary.append(String.format("%8s",Integer.toBinaryString((int) s.charAt(i))).replace(' ', '0'));
        // }

        int left = 0;
        int right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left++) != binary.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
