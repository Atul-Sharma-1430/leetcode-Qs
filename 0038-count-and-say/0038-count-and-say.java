class Solution {

    public String countAndSay(int n) {
        // logic  : basically read krte time [kitni baar kya aa rha hai] vo krna haiu toh uske hisaab se 

        // stores final ans
        String ans = "1";

        for (int i = 2; i <= n; i++) {

            // har n ke liye new banega
            StringBuilder temp = new StringBuilder();

            // har n ke liye poori string traverse krenge
            int j = 0;
            while (j < ans.length()) {

                // current digit kio ascii value isliye int kyuki bs check krna h kons num h , char bhi ue kr skte h
                int curr = ans.charAt(j);

                // count krga ki curr digit kitni baar aa rhas hai
                int count = 0;

                // next new digit ke liye k ko continue rakhna ha8i 0 se nhi st krna h
                int k = j;

                // current character kitni baar aa rha hai vo count kr rhe h
                while (k < ans.length() && ans.charAt(k) == curr) {
                    count++;
                    k++;
                }

                // then usko store kr rhe h
                temp.append(count); // kitni baar
                temp.append((char) curr); // kya aa rha h vo

                // j ko k pe move kro directly
                j = k;
            }

            ans = temp.toString();
        }

        return ans;
    }
}