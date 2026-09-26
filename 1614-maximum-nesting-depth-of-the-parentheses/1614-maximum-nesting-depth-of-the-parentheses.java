class Solution {
    public int maxDepth(String s) {

        Stack<Character> stack = new Stack<>();

        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // agar opening bracket mila
            if (ch == '(') {

                // opening bracket ko stack mein push karo
                stack.push('(');

                // and depth 1 se bad jaayega tab
                depth++;

                // current depth maximum se zyada hai toh update karo
                if (depth > maxDepth) {
                    maxDepth = depth;
                }

                // agar closing bracket mila
            } else if (ch == ')') {

                // opening bracket ko stack se remove karo
                stack.pop();

                // and depth 1 se kam ho jayega
                depth--;
            }
        }

        return maxDepth;
    }
}