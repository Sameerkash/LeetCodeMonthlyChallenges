class Solution {
    public String intToRoman(int num) {
        
        /// creating a mapping of the numerals with the 6 edge cases  900, 400, 90, 40, 9, 4
        int []intCode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String code[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i< intCode.length; i++){
        // as long as the number is greater than intCode[i] append the corresponding Numeral
            // decrement by number just upended.
            while(num >= intCode[i]){
                sb.append(code[i]);
                num-=intCode[i];
            }
        }
        return sb.toString();
    }
}