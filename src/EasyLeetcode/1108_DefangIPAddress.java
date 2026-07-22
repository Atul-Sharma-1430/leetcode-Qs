package EasyLeetcode;

import java.util.Scanner;

class DefangIPAddress {
    // TC : O(n)
    // SC : O(n)
    public static String defangIPAddress(String address) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {

            if (address.charAt(i) == '.') {
                ans.append("[.]");
            } else {
                ans.append(address.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP address: ");
        String address = sc.next();

        System.out.println("Defanged IP Address: " + defangIPAddress(address));

        sc.close();
    }
}