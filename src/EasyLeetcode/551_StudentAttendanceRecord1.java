package EasyLeetcode;

import java.util.Scanner;

class StudentAttendanceRecord1 {
    // TC : O(n)
    // SC : O(1)
    public static boolean checkRecord(String s) {
        int A = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                A++;
                if (A > 1) {
                    return false;
                }
            }

            // Check for three consecutive L's
            else if (s.charAt(i) == 'L') {
                if (i < s.length() && i + 1 < s.length() && i + 2 < s.length()) {
                    if (s.charAt(i) == 'L' &&
                            s.charAt(i + 1) == 'L' &&
                            s.charAt(i + 2) == 'L') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the attendance record: ");
        String s = sc.nextLine();

        System.out.println("Eligible for reward: " + checkRecord(s));

        sc.close();
    }
}
