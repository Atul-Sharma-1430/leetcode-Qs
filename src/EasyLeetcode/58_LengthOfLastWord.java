package EasyLeetcode;

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();

        String s = "Hello World"; // Example input
        int result = solution.lengthOfLastWord(s);

        System.out.println("Length of the last word is: " + result);
    }
}
