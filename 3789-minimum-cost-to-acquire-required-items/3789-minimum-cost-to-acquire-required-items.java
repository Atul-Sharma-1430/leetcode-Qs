class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        // Dono types ke items akele kharidne ka cost
        long a = (long) cost1 * need1 + (long) cost2 * need2;

        // Sirf Type 3 items kharidkar dono requirements complete karna
        long b = (long) costBoth * Math.max(need1, need2);

        // Common needs ke liye Type 3 wali items kharidna
        long c = (long) costBoth * Math.min(need1, need2);

        // Agar need1 jyada hai toh bache hbuye Type 1 items kharidnge
        if (need1 > need2) {
            c += (long) cost1 * (need1 - need2);
        } 
        // else bache huye Type 2 items kharidenge
        else {
            c += (long) cost2 * (need2 - need1);
        }

        // Teeno cases mein se minimum cost return karna
        return Math.min(a, Math.min(b, c));
    }
}