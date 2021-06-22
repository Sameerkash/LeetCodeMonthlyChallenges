class Solution {
    public int hammingDistance(int x, int y) {
        
        // y XOR y = 0, hence all bits similar cancel out, we only have bits set 
        int result = x^y;
        int count =0;
        
        while( result > 0){
            result &= (result - 1); 
            count++;
        }
        
        return count;
    }
}