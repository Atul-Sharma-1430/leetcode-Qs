class Solution { 
    public int[] replaceElements(int[] arr) { 

        int max = arr[arr.length - 1];  

        // Right se left traverse karenge
        for (int i = arr.length - 1; i >= 0; i--) { 

            // Last element ke right mein koi element nahi hai
            if (i == arr.length - 1) { 
                max = arr[i];      // Last element ko max bana do
                arr[i] = -1;       // Last element ko -1 se replace karo
                continue; 
            } 

            // Current element ko temporarily store karo
            int curr = arr[i]; 

            // Current element ko right side ke greatest element se replace karo
            arr[i] = max; 

            // Agar current element max se bada hai, toh current element ko new maximum bana do
            if (curr > max) { 
                max = curr; 
            } 
        } 

        return arr; 
    } 
}