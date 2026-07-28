package EasyLeetcode;
import java.util.Scanner;

class GuessNumber {
    // This is the number that we have to guess
    static int pick;

    // API jo batayega ki humara guessed number picked number se bda hai ya chota hai ya equal hai
    public static int guess(int num) {
        if (num == pick) {
            return 0;       // Correct guess
        }
        else if (num > pick) {
            return -1;      // higher
        }

        return 1;       //lower
    }

    // TC : O(n log n)
    // SC : O(1)
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // value guess krne ke baad check kro
            int result = guess(mid);

            if (result == 0) {
                return mid;
            }
            else if (result == -1) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range (n): ");
        int n = sc.nextInt();

        System.out.print("Enter picked number: ");
        pick = sc.nextInt();

        System.out.println("The number is: " + guessNumber(n));

        sc.close();
    }
}