package EasyLeetcode;

class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int point = 0;
        for (int i : nums) {
            if (i != val) {
                nums[point++] = i;
            }
        }
        return point;
    }

        public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 3};
        int val = 3;
        
        int newLength = removeElement(nums, val);
        
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
