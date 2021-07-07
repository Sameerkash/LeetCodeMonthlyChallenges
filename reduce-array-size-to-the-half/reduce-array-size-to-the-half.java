class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the number of frequencies for each number and store it in the map,
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        
        int freq[] = new int[arr.length+1];
        
        // map the frequency as the index 
        for(int i : map.keySet())
            freq[map.get(i)]++;
        
        int ans = 0,  count = 0;
        
        // for every digit, check its frequency index, decrement to zero and count increment ans
        // this means that number with frequency was removed, and the higest number frequency will be removed 
        // since we are checking in reverse.
        for(int i = arr.length; i >=0 ; i--){
                while(freq[i] --> 0){
                    ans++;
                    count+=i;
                    
                    // if there are ever half the elements from the array removed, return the ans;
                    if( count >= arr.length/2) return ans;
                }
        }
        return ans;
    }
}