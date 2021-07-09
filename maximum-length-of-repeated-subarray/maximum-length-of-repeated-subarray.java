class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Approach : Dynamic Programming using Tabulation
        int n = nums1.length;
        int m = nums2.length;
        
        int dp[][] = new int[n +1][m +1];
        int max =0;
        
        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < m+1; j++){
                // check if every number in nums1 == nums2, update the table with that value
                if(nums1[i-1] == nums2[j-1]){
                    // update the value of the table with (i-1, j-1) + 1
                    dp[i][j] = dp[i-1][j-1] + 1;
                    // keep track of the maximum length where the numbers in both the arrays macth
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}