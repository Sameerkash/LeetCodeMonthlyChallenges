class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
      
        char []letters = s.toCharArray();
        
        int l=0, r = removable.length ;
        
        while(l <= r){
            
           int  mid = (l+r)/2;
            
            for(int i= 0; i< mid; i++){
                   letters[removable[i]] = '/';
            }
            
            if(check(letters, p)) l = mid+1;
            else{
               for(int i =0; i< mid; i++) letters[removable[i]] = s.charAt(removable[i]);
            r = mid-1;   
            }
          
        }
        
        return r;
    }
    
    
    boolean check(char []letters, String p){
        int i =0, j=0;
        
        while(i< letters.length && j < p.length()){
            
            if(letters[i]!= '/' && letters[i] == p.charAt(j)) j++;
            i++;
        }
          return j == p.length();
    }
}