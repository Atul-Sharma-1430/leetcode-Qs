package EasyLeetcode;

import java.util.Scanner;

class ColorOfChessBoard {

    public static boolean squareIsWhite(String coordinates) {
        String str1 = "aceg";
        String str2 = "1357";

        if (str1.contains(String.valueOf(coordinates.charAt(0))) &&
                str2.contains(String.valueOf(coordinates.charAt(1)))) {
            return false;
        }

        else if (!str1.contains(String.valueOf(coordinates.charAt(0))) &&
                str2.contains(String.valueOf(coordinates.charAt(1)))) {
            return true;
        }

        else if (str1.contains(String.valueOf(coordinates.charAt(0))) &&
                !str2.contains(String.valueOf(coordinates.charAt(1)))) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coordinates (e.g., a1): ");
        String coordinates = sc.next();

        System.out.println(squareIsWhite(coordinates));

        sc.close();
    }
}
