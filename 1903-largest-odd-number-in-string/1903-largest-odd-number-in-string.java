class Solution {
    public String largestOddNumber(String num) {

        // Agar last digit odd hai toh pura number already odd hai
        int last = num.charAt(num.length() - 1) - '0';
        if (last % 2 != 0) {
            return num;
        }

        // Right se first odd digit find karo kyuki String me st se leke jo last odd digit aayega wahi sabse bda odd number hoga
        int index = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int val = num.charAt(i) - '0';

            if (val % 2 != 0) {
                index = i;
                break;
            }
        }

        // Agar koi odd digit nahi mila toh koi odd number possible nahi hai toh empty string return
        if (index == -1) {
            return "";
        }

        // start se leke jo odd digit sabse last me ayega waha tak ka num sabse bda odd num hoga
        return num.substring(0, index + 1);
    }
}