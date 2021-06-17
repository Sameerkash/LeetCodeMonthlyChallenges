class Solution {
    public void moveZeroes(int[] nums) {
        
     int insert = 0;
        
        for( int n : nums){
            
            if( n != 0) nums[insert++] = n;
        }
        
        while( insert < nums.length)
            nums[insert++] = 0;
    }
}