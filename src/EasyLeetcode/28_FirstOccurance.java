import java.util.Scanner;

class FirstOccurance {
    public int strStr(String s1, String s2) {
        int ptr = 0, index = -1;
        int ptr1 = 0;
        while (ptr < s2.length() && ptr1 < s1.length()) {
            if (s1.charAt(ptr1) == s2.charAt(ptr)) {
                ptr++;
                ptr1++;
            } else {
                ptr1 = ptr1 - ptr + 1;
                ptr = 0;
            }
            if (ptr == 1) {
                index = ptr1 - 1;
            }
        }
        return ptr < s2.length() ? -1 : index;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter the substring to search: ");
        String s2 = sc.nextLine();

        FirstOccurance solution = new FirstOccurance();
        int result = solution.strStr(s1, s2);

        if (result != -1) {
            System.out.println("Substring found at index: " + result);
        } else {
            System.out.println("Substring not found.");
        }

        sc.close();
    }
}

