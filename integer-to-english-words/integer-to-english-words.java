class Solution {
    
    private final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
private final String[] thousands = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
         
        // edge case
     if (num == 0) return "Zero";
      
        StringBuilder sb = new StringBuilder();
        int weight = 0;
        
        while(num > 0){
            
            // subgroup in thousands (less than three digits)
            int n = num % 1000;
            
            /// get the String for those three digits
            String s = getString(n);
            
            // if the string is not empty in the second iteration, it is > 1000, and for 3rd > million and so on...
            // Hence inssert the number obtained + the position
            if(s.length() != 0)
                sb.insert(0, " " + s +  thousands[weight]);
            
            weight++;
            num /= 1000;
            // decrement by 1000 the (subgroup)
        }
        return sb.toString().trim();
    }
    
    String getString(int num){
        
        if(num == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        // get the digit in the Hundredth position
        int h = num / 100;
        if( h != 0) sb.append(ones[h] + " " + "Hundred");
        
        // if the digit is less than 20, we need to use the ones map, else tens so make a check 
        num = num % 100;
        if(num < 20) {
            sb.append(" " + ones[num]);
            return sb.toString().trim();
        }
        
        // get the tens position
        int t = num / 10;
        if( t != 0) sb.append(" " + tens[t]);
        
        // get the ones position
        num = num %10;
        if(num != 0) sb.append(" "+ ones[num]);
        
        return sb.toString().trim();
    }
}