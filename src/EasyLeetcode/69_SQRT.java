import java.util.Scanner;

class SQRT {
    public int mySqrt(long number) {
        if (number == 0) return 0;

        long start = 1;
        long end = number / 2;
        long result = 1;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == number) {
                return (int) mid; 
            } else if (mid * mid < number) {
                result = mid;     
                start = mid + 1;  
            } else {
                end = mid - 1;     
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to find its square root: ");
        long number = sc.nextLong();

        SQRT solution = new SQRT();
        int sqrt = solution.mySqrt(number);

        System.out.println("Integer square root of " + number + " is: " + sqrt);

        sc.close();
    }
}
