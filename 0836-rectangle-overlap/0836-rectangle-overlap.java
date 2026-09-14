class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // humko dono check krna hoga kyuki ye nhi pta ki kaunsa rect bda hai isliye

        // rec1 ka right, rec2 ke left se aage hona chahiye
        // rec1 ka top, rec2 ke bottom se uper hona chahiye
        if (rec1[2] > rec2[0] && rec1[3] > rec2[1]) {

            // rec2 ka right, rec1 ke left se aage hona chahiye
            // rec2 ka top, rec1 ke bottom se uper hona chahiye
            if (rec2[2] > rec1[0] && rec2[3] > rec1[1]) {
                return true;
            }
        }

        return false;
    }
}