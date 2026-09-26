class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // convrtng knowldg into map 
        HashMap<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        // StringBuilder to store answer
        StringBuilder ans = new StringBuilder("");

        int i = 0;

        while (i < s.length()) {

            // agar ( mila toh ek code start hua
            if (s.charAt(i) == '(') {

                String code = "";
                int j = i + 1;

                // store code till )
                while (s.charAt(j) != ')') {
                    code += s.charAt(j);
                    j++;
                }

                // if code prsnt then add its value
                if (map.containsKey(code)) {
                    ans.append(map.get(code));
                }
                // else add ?
                else {
                    ans.append("?");
                }

                // i ko code ke baad wale bracketp pr point kr do
                i = j;

            } else {
                // normal character hai toh directly answer mein add karo
                ans.append(s.charAt(i));
            }

            i++;
        }

        return ans.toString();
    }
}