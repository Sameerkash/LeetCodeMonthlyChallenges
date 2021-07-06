class Solution {
    public int trap(int[] height) {
        // Two pointer appraoch, calculate the pointer on the go.
        // time : O(n)  space : O(1)

        int lo = 0, hi = height.length-1;
        int leftMax = 0, rightMax = 0;
        int water =0;
        
        while( lo < hi){
            
            // update the pointer if it comes across a height greater than the pointer
            if(height[lo] > leftMax) leftMax = height[lo];    
            if(height[hi] > rightMax) rightMax = height[hi];
        
            // if left < right then the water height is left, so the current water is left - height[i]
            if(leftMax < rightMax){
                water+= (leftMax - height[lo]);
                ++lo;
            // else the maximum height water can fill is right, so right - height[i]
            }else{
                water+= (rightMax - height[hi]);
                --hi;
            }
        }
        return water;
    }
}