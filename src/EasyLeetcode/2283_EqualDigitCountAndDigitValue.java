package EasyLeetcode;
import java.util.HashMap;
import java.util.Scanner;

class EqualDigitCountAndDigitValue {
    // TC: O(n)
    // SC: O(9) --> as mao stores only the digits from 1 to 9
    public static boolean digitCount(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store the frequency of each digit
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        // Check kro ki har index ki freq us index ki value ki equal hai ya nhi
        for (int i = 0; i < s.length(); i++) {

            // If a digit is not present in the map,
            // its frequency is considered 0.
            // agar koi key nhi hai toh uska freq 0 rhega
            // eg 030 me index 2 ki value 0 hai means 2 string me 0 baar aa rha hai isliye default value 0 jo absent hai
            if (map.getOrDefault(i, 0) != s.charAt(i) - '0') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.next();

        System.out.println("Result: " + digitCount(s));

        sc.close();
    }
}