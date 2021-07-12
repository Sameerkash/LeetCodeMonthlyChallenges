class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
         Boolean[] dp = new Boolean[s.length() + 1];
     Set<String> set = new HashSet<>();
    set.addAll(wordDict);
        
        dp[0] = true;
        
        for(int i = 1; i< dp.length; i++){
            for(int j = 0; j< i ; j++){
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
    
        return dp[s.length()];
    }
}