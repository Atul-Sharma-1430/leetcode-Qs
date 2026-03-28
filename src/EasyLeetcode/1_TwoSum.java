import java.util.Scanner;
import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        TwoSum obj = new TwoSum();
        int[] result = obj.twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices of elements that sum to target: " + Arrays.toString(result));
        } else {
            System.out.println("No two elements sum to the target.");
        }

        sc.close();
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}
