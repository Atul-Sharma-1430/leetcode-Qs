package EasyLeetcode;
import java.util.Arrays;
import java.util.Scanner;

class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); 
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        MajorityElement sol = new MajorityElement();
        int majority = sol.majorityElement(nums);
        System.out.println("The majority element is: " + majority);

        sc.close();
    }
}
