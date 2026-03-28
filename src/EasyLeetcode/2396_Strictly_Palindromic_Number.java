class StrictlyPalindromicNumber {
    static public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i <= n-2; i++) {
            String val = baseConvert(n , i);
            if(!isPalindrome(val)) return false;
        }
        return true;
    }

    static public String baseConvert(int num , int base) {
        String val = "";
        while(num != 0) {
            int rem = num % base;
            val = rem + val;
            num /= base;
        }
        return val;
    }

    static public boolean isPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(4));
    }
    
}
