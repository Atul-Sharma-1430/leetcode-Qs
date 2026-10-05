class Solution {
    public int minRotations(String s) {

        int rotns = 0;
        int ptr = 0; // st postion

        for (int i = 0; i < s.length(); i++) {

            // current number to dial
            int curr = (int) (s.charAt(i) - '0');

            // diff between curr and abhi pointer jaha pe hai vo 
            int diff = Math.abs(curr - ptr);

            // rotns me clockwise and anticlockwise ka min add krenge
            rotns += Math.min(diff, 10 - diff);

            // pointer ko current num pe move kr do for next num
            ptr = curr;
        }

        return rotns;
    }
}