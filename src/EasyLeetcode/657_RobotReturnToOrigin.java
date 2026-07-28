package EasyLeetcode;

import java.util.Scanner;

class RobotReturnToOrigin {
    // TC : O(n)
    // SC : O(1)
    public static boolean judgeCircle(String moves) {
        int U = 0;
        int R = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                U++;
            } else if (moves.charAt(i) == 'D') {
                U--;
            } else if (moves.charAt(i) == 'R') {
                R++;
            } else {
                R--;
            }
        }

        return R == 0 && U == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the moves: ");
        String moves = sc.nextLine();

        System.out.println("Returns to origin: " + judgeCircle(moves));

        sc.close();
    }
}