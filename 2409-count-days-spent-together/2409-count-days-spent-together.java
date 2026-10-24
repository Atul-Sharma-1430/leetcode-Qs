class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int aliceArrivalDay = convertToDays(arriveAlice, daysInMonth);
        int aliceLeavingDay = convertToDays(leaveAlice, daysInMonth);

        int bobArrivalDay = convertToDays(arriveBob, daysInMonth);
        int bobLeavingDay = convertToDays(leaveBob, daysInMonth);

        // Dono me se jo late arrive karega vpo starting day hoga
        int startDay = Math.max(aliceArrivalDay, bobArrivalDay);

        // Dono me se jo jaldi leave karega voending day hoga
        int endDay = Math.min(aliceLeavingDay, bobLeavingDay);

        return Math.max(0, endDay - startDay + 1);
    }

    public int convertToDays(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        // Total days me current month ka day add karna
        int totalDays = day;

        // Current month se pehle ke saare months ke days add karna
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        return totalDays;
    }
}