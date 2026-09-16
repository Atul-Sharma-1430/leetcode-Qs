class Solution {
    public long countCommas(long n) {

        // 1000 se chhote numbers mein koi comma nahi hota
        if (n < 1000) {
            return 0;
        }

        // final ans total commas
        long commas = 0;
        // current range me kitne number rhenge vo rakhne ke loiye
        long totalNums = 0;

        // har range ka start valye store krne ke liye
        // 1st comma 1000 se shuru hota h
        long start = 1000;

        // har range me kitne commas rhenge usko store krunga
        long commaCount = 1;

        // har range ke liye loop chalga and check krenge ki kya range ka st n se kam hai ki nhi
        while (start <= n) {

            // Current range ka last number nikalenge
            long end = start * 1000 - 1;

            // aga us range ka last number(end) n se bda hua toh last numbe(end) me n daal denge
            if (end > n) {
                end = n;
            }

            // fir count krenge ki vo range me kitne total number hai
            totalNums = end - start + 1;

            // fir us range me har number me jitne commas rhenge usko numbner se multiply kr denge to get total commas in trhat range and add kr denge
            commas += totalNums * commaCount;

            // next range ke start pe jaynge jisme comma count 2 rhegas
            start *= 1000;

            // isliye comma ko 1 se increase
            commaCount++;
        }

        return commas;
    }
}