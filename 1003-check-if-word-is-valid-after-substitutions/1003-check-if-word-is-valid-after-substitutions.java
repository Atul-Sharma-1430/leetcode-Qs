class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == 'b' || s.charAt(i) == 'c') && stack.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == 'a' || s.charAt(i) == 'b') {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() < 2) {
                    return false;
                }

                char prev1 = stack.pop();
                char prev2 = stack.pop();

                if (prev1 != 'b' || prev2 != 'a') {
                    return false;
                }
            }
        }

        return stack.isEmpty();






        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == 'a') {
        //         count += 2;
        //     } else if (s.charAt(i) == 'b') {
        //         if (count < 2) {
        //             return false;
        //         } else {
        //             count--;
        //         }
        //     } else {
        //         if (count < 1) {
        //             return false;
        //         } else {
        //             count--;
        //         }
        //     }
        // }

        // return count == 0;

    }
}