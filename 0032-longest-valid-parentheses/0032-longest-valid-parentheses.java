class Solution {
    public int longestValidParentheses(String s) {
        int openB = 0;
        int closeB = 0;

        int longest = 0;

        // from left to rght
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openB++;
            } else {
                closeB++;
            }

            if (openB == closeB) {
                longest = Math.max(longest, openB * 2);
            } else if (closeB > openB) {
                openB = 0;
                closeB = 0;
            }
        }

        openB = 0;
        closeB = 0;

        // from right to lft+
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                openB++;
            } else {
                closeB++;
            }

            if (openB == closeB) {
                longest = Math.max(longest, openB * 2);
            } else if (openB > closeB) {
                openB = 0;
                closeB = 0;
            }
        }

        return longest;


















        // if (s.length() == 0) {
        //     return 0;
        // }

        // Stack<Integer> stack = new Stack<>();

        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);

        //     if (stack.isEmpty() || (s.charAt(stack.peek()) == ')' && s.charAt(i) == ')') || s.charAt(i) == '(') {
        //         stack.push(i);
        //     } else {
        //         int index = i;
        //         stack.pop();
        //         int st = 0;
        
        //         if (stack.isEmpty()) {
        //             st--;
        //         } else {
        //             st = stack.peek();
        //         }

        //         count = Math.max(count, (index - st));
        //     }
        // }

        // return count;

    }
}