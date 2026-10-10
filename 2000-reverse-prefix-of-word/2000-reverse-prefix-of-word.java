class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();

        int st = 0;
        int end = 0;

        while (end < arr.length && arr[end] != ch) {
            end++;
        }

        if (end == arr.length) {
            return word;
        }

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