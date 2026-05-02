package EasyLeetcode;
import java.util.ArrayList;
import java.util.List;

class ExtraCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> output = new ArrayList<>();

        int max = candies[0];
        for (int i : candies) {
            if (i > max) 
                max = i;
        }

        for (int i : candies) {
            if (i + extraCandies >= max) {
                output.add(true);
            } else {
                output.add(false);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        ExtraCandies solution = new ExtraCandies();

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);

        System.out.println("Result: " + result);
    }
}
