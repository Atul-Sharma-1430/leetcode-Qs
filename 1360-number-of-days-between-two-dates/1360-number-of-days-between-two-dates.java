class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int y1 = 0;
        int y2 = 0;

        int m1 = 0;
        int m2 = 0;

        int d1 = 0;
        int d2 = 0;

        int i = 0;
        String s1 = "";
        String s2 = "";

        // getting yr
        while (i < date1.length() && date1.charAt(i) != '-') {
            s1 += date1.charAt(i);
            s2 += date2.charAt(i);
            i++;
        }

        y1 = Integer.parseInt(s1);
        y2 = Integer.parseInt(s2);

        // Year extract hone ke baad strings reset kar rahe hain
        s1 = "";
        s2 = "";
        i++;

        // getting month
        while (i < date1.length() && date1.charAt(i) != '-') {
            s1 += date1.charAt(i);
            s2 += date2.charAt(i);
            i++;
        }

        m1 = Integer.parseInt(s1);
        m2 = Integer.parseInt(s2);

        // Month extract hone ke baad strings reset kar rahe hain
        s1 = "";
        s2 = "";
        i++;

        // getting date
        while (i < date1.length()) {
            s1 += date1.charAt(i);
            s2 += date2.charAt(i);
            i++;
        }

        d1 = Integer.parseInt(s1);
        d2 = Integer.parseInt(s2);

        int days = 0;

        // days in monmth
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int total1 = d1;

        // Current year mein pichhle complete months ke days add kar rahe hain
        for (i = 1; i < m1; i++) {
            total1 += monthDays[i - 1];

            if (i == 2 && (y1 % 400 == 0 || (y1 % 4 == 0 && y1 % 100 != 0))) {
                total1++;
            }
        }

        // Year 1 se pichhle saal tak ke total days add kar rahe hain
        for (i = 1; i < y1; i++) {
            // leap yr
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                total1 += 366;
            }
            // normal yr
            else {
                total1 += 365;
            }
        }

        int total2 = d2;

        // Current year mein pichhle complete months ke days add kar rahe hain
        for (i = 1; i < m2; i++) {
            total2 += monthDays[i - 1];

            if (i == 2 && (y2 % 400 == 0 || (y2 % 4 == 0 && y2 % 100 != 0))) {
                total2++;
            }
        }

        // Year 1 se pichhle saal tak ke total days add kar rahe hain
        for (i = 1; i < y2; i++) {
            // leap yr
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                total2 += 366;
            }
            // norml yr
            else {
                total2 += 365;
            }
        }

        return Math.abs(total1 - total2);
    }
}
