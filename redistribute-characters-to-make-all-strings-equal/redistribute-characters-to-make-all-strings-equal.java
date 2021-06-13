class Solution {
    public boolean makeEqual(String[] words) {
     
     int []freq = new int[26];
        
        for(String w : words){
            for( char e : w.toCharArray()){
                freq[e-'a'] +=1; 
            }
        }
        
        for(int i =0; i< 26; i++){
            if(freq[i] % words.length != 0) return false;
            
        }
        
        return true;
    }
}