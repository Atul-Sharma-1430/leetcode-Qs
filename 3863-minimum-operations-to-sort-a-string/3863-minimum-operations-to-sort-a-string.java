
class Solution {
    public int minOperations(String s) {

        // Check kar rahe hain ki string pehle se sorted hai ya nahi
        boolean isSorted = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }

        // Agar string pehle se sorted hai toh 0 
        if (isSorted) {
            return 0;
        }

        // Agar length 2 hai toh string ko sort nahi kar sakte kyunki poori string me se substring mein select nahi kar sakte
        if (s.length() == 2) {
            return -1;
        }

        // String ka sabse chhota aur sabse bada character find kar rahe hain
        char min = 'z';
        char max = 'a';

        for (int i = 0; i < s.length(); i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        // Agar smallest character first position par hai n largest character last position par hai toh sirf 1 operation mein string sort ho sakti hai
        if (s.charAt(0) == min || s.charAt(s.length() - 1) == max) {
            return 1;
        }

        // Agar largest character first position par hai n smallest character last position par hai toh 3 operations lagenge
        if (s.charAt(0) == max && s.charAt(s.length() - 1) == min) {
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == min || s.charAt(i) == max) {
                    return 2;
                }
            }
            return 3;
        }

        // Agar upar ki koi condition satisfy nahi hui toh 2 operations lagenge
        return 2;
    }
}
