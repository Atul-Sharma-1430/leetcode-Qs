class Solution {
    public String reformat(String s) {
        if (s.matches("[a-zA-Z]+") || s.matches("[0-9]+")) {
            return "";
        }

        String ans = "";

        String alphas = "";
        String numbers = "";

        int letters = 0;
        int nums = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                alphas += s.charAt(i);
                letters++;
            } else {
                numbers += s.charAt(i);
                nums++;
            }
        }

        if (Math.abs(letters - nums) > 1) {
            return "";
        }

        int i = 0;
        int j = 0;

        // Agar letters zyada hain toh pehle alphabet add krnge
        if (letters >= nums) {
            while (i < alphas.length() || j < numbers.length()) {
                if (i < alphas.length()) {
                    ans += alphas.charAt(i++);
                }

                if (j < numbers.length()) {
                    ans += numbers.charAt(j++);
                }
            }
        } else {
            // Agar numbers zyada hain toh pehle number add kenge
            while (i < alphas.length() || j < numbers.length()) {
                if (j < numbers.length()) {
                    ans += numbers.charAt(j++);
                }

                if (i < alphas.length()) {
                    ans += alphas.charAt(i++);
                }
            }
        }

        return ans;
    }
}