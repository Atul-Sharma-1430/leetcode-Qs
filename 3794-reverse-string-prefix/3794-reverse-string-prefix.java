class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();

        int st = 0;
        int end = k - 1;

        while (st <= end) {
            char temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }

        return new String(arr);
    }
}