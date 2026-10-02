class Solution {
    public static void function(int openB, int closeB, String curr, List<String> ans) {
        // if both brackkets count becomes zerro means combination is done so add to ans 
        if (openB == 0 && closeB == 0) {
            ans.add(curr);
        }

        // base case
        if (openB < 0 || closeB < 0) {
            return;
        }
            

        // for (  bracket
        function(openB - 1, closeB, curr + "(", ans);

        // for )  bracket
        // ye if me bcz agar open brckt hua hai tabhi close brck lagana hai wanra )( ye bhi aa skta h
        if (closeB > openB) {
            function(openB, closeB - 1, curr + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {

        // store final ans
        List<String> ans = new ArrayList();

        // current combination store krega 
        String curr = "";

        // st me openB and closeB count same rhega islie n , n
        function(n, n, curr, ans);

        return ans;
    }
}