package EasyLeetcode;
import java.util.Scanner;

class PassThePillow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        System.out.print("Enter time: ");
        int time = sc.nextInt();

        System.out.println("Player holding the pillow after " + time + " seconds: " + findPlayer(n, time));

        sc.close();
    }

    // TC : O(time)
    // SC : (k)
    public static int findPlayer(int n, int time) {

        int ans = 1;
        int direction = 1;
        int count = 1;

        for (int i = 1; i <= time; i++) {

            if (direction == 1) {
                ans++;
            } else {
                ans--;
            }

            count++;

            if (count == n) {
                count = 1;
                direction = -direction;
            }
        }

        return ans;
    }
}